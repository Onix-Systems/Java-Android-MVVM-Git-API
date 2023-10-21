package com.android.gitapi.domain.usecase;

import com.android.gitapi.domain.database.entity.RepositoryEntity;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.repository.DataBaseRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddFavouriteUseCase extends BaseUseCase<Completable, ProjectItemModel> {

    private final DataBaseRepository dataBaseRepository;

    @Inject
    public AddFavouriteUseCase(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    protected Completable buildUseCaseSingle(ProjectItemModel itemModel) {
        return Completable.fromAction(() -> {
            RepositoryEntity repositoryEntity = new RepositoryEntity();
            repositoryEntity.setOwnerUser(itemModel.getOwnerUser());
            repositoryEntity.setDescription(itemModel.getDescription());
            repositoryEntity.setRepositoryName(itemModel.getRepositoryName());
            repositoryEntity.setAvatarUrl(itemModel.getAvatarUrl());
            repositoryEntity.setCreatedAt(itemModel.getCreatedAt());
            repositoryEntity.setForks(itemModel.getForks());
            repositoryEntity.setHtmlUrl(itemModel.getHtmlUrl());
            repositoryEntity.setLanguage(itemModel.getLanguage());
            repositoryEntity.setStars(itemModel.getStars());

            dataBaseRepository.insertRepository(repositoryEntity);
        }).subscribeOn(Schedulers.io());
    }
}

