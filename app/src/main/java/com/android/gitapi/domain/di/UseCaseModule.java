package com.android.gitapi.domain.di;

import com.android.gitapi.domain.repository.DataBaseRepository;
import com.android.gitapi.domain.repository.MapperRepository;
import com.android.gitapi.domain.repository.ProjectsListRepository;
import com.android.gitapi.domain.usecase.AddFavouriteUseCase;
import com.android.gitapi.domain.usecase.DeleteFavouriteUseCase;
import com.android.gitapi.domain.usecase.GetFavouritesUseCase;
import com.android.gitapi.domain.usecase.GetRepositoryListUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public GetRepositoryListUseCase provideGetRepositoryListUseCase(ProjectsListRepository repository, MapperRepository mapperRepository) {
        return new GetRepositoryListUseCase(repository, mapperRepository);
    }

    @Provides
    public AddFavouriteUseCase provideAddFavouriteUseCase(DataBaseRepository dataBaseRepository) {
        return new AddFavouriteUseCase(dataBaseRepository);
    }

    @Provides
    public DeleteFavouriteUseCase provideDeleteFavouriteUseCase(DataBaseRepository dataBaseRepository) {
        return new DeleteFavouriteUseCase(dataBaseRepository);
    }

    @Provides
    public GetFavouritesUseCase provideGetFavouritesUseCase(DataBaseRepository dataBaseRepository) {
        return new GetFavouritesUseCase(dataBaseRepository);
    }
}
