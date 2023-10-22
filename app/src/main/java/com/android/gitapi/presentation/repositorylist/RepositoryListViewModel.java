package com.android.gitapi.presentation.repositorylist;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.gitapi.data.model.TimePeriod;
import com.android.gitapi.data.repository.RepositorySearchQuery;
import com.android.gitapi.domain.database.entity.RepositoryEntity;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.model.ProjectRequestModel;
import com.android.gitapi.domain.usecase.AddFavouriteUseCase;
import com.android.gitapi.domain.usecase.DeleteFavouriteUseCase;
import com.android.gitapi.domain.usecase.GetFavouritesUseCase;
import com.android.gitapi.domain.usecase.GetRepositoryListUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class RepositoryListViewModel extends ViewModel {

    GetRepositoryListUseCase getRepositoryListUseCase;
    AddFavouriteUseCase addFavouriteUseCase;
    DeleteFavouriteUseCase deleteFavouriteUseCase;
    GetFavouritesUseCase getFavouritesUseCase;

    List<RepositoryEntity> repositoryEntities;

    private ObservableBoolean observableBoolean = new ObservableBoolean(false);
    private final ObservableBoolean observableBooleanEmptyList = new ObservableBoolean(true);


    public ObservableBoolean getObservableBoolean() {
        return observableBoolean;
    }

    public ObservableBoolean getObservableBooleanEmptyList() {
        return observableBooleanEmptyList;
    }

    public void setObservableBoolean(ObservableBoolean observableBoolean) {
        this.observableBoolean = observableBoolean;
    }

    private final MutableLiveData<List<ProjectItemModel>> repositoryListLiveData = new MutableLiveData<>();
    private int totalCount = 0;
    private int currentPage = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private TimePeriod timePeriod = TimePeriod.LAST_DAY;

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public MutableLiveData<List<ProjectItemModel>> getRepositoryListLiveData() {
        return repositoryListLiveData;
    }

    boolean isLoading = false;

    public void loadNextPage() {
        if (isLoading || totalCount <= repositoryListLiveData.getValue().size()) {
            return;
        }

        currentPage++;
        isLoading = true;
        fetchRepositoryList(new ProjectRequestModel(parseQueryDate(getTimePeriod()), String.valueOf(currentPage)));
    }

    @Inject
    public RepositoryListViewModel(GetRepositoryListUseCase useCase, GetFavouritesUseCase getFavouritesUseCase, AddFavouriteUseCase addFavouriteUseCase, DeleteFavouriteUseCase deleteFavouriteUseCase) {
        this.getRepositoryListUseCase = useCase;
        this.getFavouritesUseCase = getFavouritesUseCase;
        this.addFavouriteUseCase = addFavouriteUseCase;
        this.deleteFavouriteUseCase = deleteFavouriteUseCase;

        repositoryEntities = getFavouritesUseCase.execute(null);
        fetchRepositoryList(new ProjectRequestModel(parseQueryDate(TimePeriod.LAST_DAY), String.valueOf(currentPage)));
    }

    @SuppressLint("CheckResult")
    public void fetchRepositoryList(ProjectRequestModel model) {
        observableBoolean.set(true);
        getRepositoryListUseCase.execute(model)
                .subscribe(
                        repositoryList -> {
                            totalCount = repositoryList.getTotalCount();
                            List<ProjectItemModel> existingList = repositoryListLiveData.getValue();

                            if (existingList == null) {
                                existingList = new ArrayList<>();
                            }

                            if (getCurrentPage() == 1) existingList.clear();

                            for (RepositoryEntity e : repositoryEntities) {
                                for (int i = 0; i < repositoryList.getItems().size(); i++) {
                                    ProjectItemModel projectItemModel = repositoryList.getItems().get(i);

                                    if (e.getRepositoryName().equals(projectItemModel.getRepositoryName())) {
                                        ProjectItemModel newModel = repositoryList.getItems().get(i);
                                        newModel.setFavourite(true);
                                        repositoryList.getItems().set(i, newModel);
                                    }
                                }
                            }

                            existingList.addAll(repositoryList.getItems());
                            observableBooleanEmptyList.set(existingList.size() == 0);
                            repositoryListLiveData.setValue(existingList);
                            isLoading = false;
                            observableBoolean.set(false);
                        },
                        error -> {
                            Log.e("apiError", Objects.requireNonNull(error.getMessage()));
                            isLoading = false;
                            observableBoolean.set(false);
                            if (repositoryListLiveData.getValue() == null || repositoryListLiveData.getValue().size() == 0) {
                                observableBooleanEmptyList.set(true);
                            }
                        }
                );
    }

    public String parseQueryDate(TimePeriod startDate) {
        String dateRange = RepositorySearchQuery.getDateRange(startDate);
        return "created:" + dateRange;
    }

    @SuppressLint("CheckResult")
    public void onFavouriteClick(ProjectItemModel itemModel) {
        RepositoryEntity existingEntity = null;

        for (RepositoryEntity entity : repositoryEntities) {
            if (entity.getRepositoryName().equals(itemModel.getRepositoryName())) {
                existingEntity = entity;
                break;
            }
        }

        if (existingEntity != null) {
            deleteFavouriteUseCase.execute(existingEntity.getRepositoryName())
                    .subscribe(
                            () -> {
                                repositoryEntities = getFavouritesUseCase.execute(null);
                            },
                            error -> {
                                Log.e("deleteError", Objects.requireNonNull(error.getMessage()));
                            }
                    );
        } else {
            addFavouriteUseCase.execute(itemModel)
                    .subscribe(
                            () -> {
                                repositoryEntities = getFavouritesUseCase.execute(null);
                            },
                            error -> {
                                Log.e("addError", Objects.requireNonNull(error.getMessage()));
                            }
                    );
        }
    }

}
