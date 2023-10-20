package com.android.gitapi.presentation.repositorylist;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.gitapi.data.model.TimePeriod;
import com.android.gitapi.data.repository.RepositorySearchQuery;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.model.ProjectRequestModel;
import com.android.gitapi.domain.usecase.GetRepositoryListUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class RepositoryListViewModel extends ViewModel {

    GetRepositoryListUseCase getRepositoryListUseCase;

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
    public RepositoryListViewModel(GetRepositoryListUseCase useCase) {
        this.getRepositoryListUseCase = useCase;
        fetchRepositoryList(new ProjectRequestModel(parseQueryDate(TimePeriod.LAST_DAY), String.valueOf(currentPage)));
    }

    @SuppressLint("CheckResult")
    public void fetchRepositoryList(ProjectRequestModel model) {
        getRepositoryListUseCase.execute(model)
                .subscribe(
                        repositoryList -> {
                            totalCount = repositoryList.getTotalCount();
                            List<ProjectItemModel> existingList = repositoryListLiveData.getValue();

                            if (existingList == null) {
                                existingList = new ArrayList<>();
                            }

                            if (getCurrentPage() == 1) existingList.clear();

                            existingList.addAll(repositoryList.getItems());
                            repositoryListLiveData.setValue(existingList);
                            isLoading = false;
                        },
                        error -> {
                            Log.e("apiError", Objects.requireNonNull(error.getMessage()));
                            isLoading = false;
                        }
                );
    }


    String parseQueryDate(TimePeriod startDate) {
        String dateRange = RepositorySearchQuery.getDateRange(startDate);
        return "created:" + dateRange;
    }
}
