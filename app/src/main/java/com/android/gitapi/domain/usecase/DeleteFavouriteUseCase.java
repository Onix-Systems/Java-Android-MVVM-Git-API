package com.android.gitapi.domain.usecase;

import com.android.gitapi.domain.repository.DataBaseRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DeleteFavouriteUseCase extends BaseUseCase<Completable, String> {

    private final DataBaseRepository dataBaseRepository;

    @Inject
    public DeleteFavouriteUseCase(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    protected Completable buildUseCaseSingle(String repositoryName) {
        return Completable.fromAction(() -> {
            dataBaseRepository.deleteRepository(repositoryName);
        }).subscribeOn(Schedulers.io());
    }
}
