package com.android.gitapi.presentation.favourites;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.gitapi.domain.database.entity.RepositoryEntity;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.repository.DataBaseRepository;
import com.android.gitapi.domain.usecase.GetFavouritesUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FavouritesViewModel extends ViewModel {
    GetFavouritesUseCase favouritesUseCase;
    DataBaseRepository dataBaseRepository;


    private final MutableLiveData<List<ProjectItemModel>> items = new MutableLiveData<>();
    private final ObservableBoolean observableBooleanProgress = new ObservableBoolean(false);
    private final ObservableBoolean observableBooleanEmptyList = new ObservableBoolean(true);

    public ObservableBoolean getObservableBooleanEmptyList() {
        return observableBooleanEmptyList;
    }

    public MutableLiveData<List<ProjectItemModel>> getItems() {
        return items;
    }

    public ObservableBoolean getObservableBooleanProgress() {
        return observableBooleanProgress;
    }

    @Inject
    public FavouritesViewModel(GetFavouritesUseCase favouritesUseCase, DataBaseRepository dataBaseRepository) {
        this.favouritesUseCase = favouritesUseCase;
        this.dataBaseRepository = dataBaseRepository;
    }

    void fetchFavourites() {
        observableBooleanProgress.set(true);
        List<RepositoryEntity> list = favouritesUseCase.execute(null);
        List<ProjectItemModel> items = new ArrayList<>();
        for (RepositoryEntity entity :
                list) {
            items.add(parseFavourites(entity));
        }
        this.items.setValue(items);
        setObservableBooleanEmptyList(items.size());
        observableBooleanProgress.set(false);
    }

    private void setObservableBooleanEmptyList(int listSize) {
        observableBooleanEmptyList.set(listSize <= 0);
    }

    void onFavouriteClick(ProjectItemModel projectItemModel) {
        String repositoryNameToMatch = projectItemModel.getRepositoryName();

        List<RepositoryEntity> favorites = favouritesUseCase.execute(null);

        RepositoryEntity itemToRemove = null;
        for (RepositoryEntity item : favorites) {
            if (repositoryNameToMatch.equals(item.getRepositoryName())) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            favorites.remove(itemToRemove);
            dataBaseRepository.deleteRepository(repositoryNameToMatch);
            fetchFavourites();
        }
    }


    private ProjectItemModel parseFavourites(RepositoryEntity itemModel) {
        ProjectItemModel projectItemModel = new ProjectItemModel();
        projectItemModel.setOwnerUser(itemModel.getOwnerUser());
        projectItemModel.setDescription(itemModel.getDescription());
        projectItemModel.setRepositoryName(itemModel.getRepositoryName());
        projectItemModel.setAvatarUrl(itemModel.getAvatarUrl());
        projectItemModel.setCreatedAt(itemModel.getCreatedAt());
        projectItemModel.setForks(itemModel.getForks());
        projectItemModel.setHtmlUrl(itemModel.getHtmlUrl());
        projectItemModel.setLanguage(itemModel.getLanguage());
        projectItemModel.setStars(itemModel.getStars());
        projectItemModel.setFavourite(true);
        return projectItemModel;
    }

}
