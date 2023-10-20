package com.android.gitapi.domain.usecase;

import com.android.gitapi.domain.database.entity.RepositoryEntity;
import com.android.gitapi.domain.repository.DataBaseRepository;

import java.util.List;

import javax.inject.Inject;

public class GetFavouritesUseCase extends BaseUseCase<List<RepositoryEntity>, Void> {

    DataBaseRepository dataBaseRepository;

    @Inject
    public GetFavouritesUseCase(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    protected List<RepositoryEntity> buildUseCaseSingle(Void params) {
        return dataBaseRepository.getFavourites();
    }
}
