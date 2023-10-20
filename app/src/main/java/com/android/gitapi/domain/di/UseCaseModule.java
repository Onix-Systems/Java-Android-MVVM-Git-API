package com.android.gitapi.domain.di;

import com.android.gitapi.domain.repository.MapperRepository;
import com.android.gitapi.domain.repository.ProjectsListRepository;
import com.android.gitapi.domain.usecase.GetRepositoryListUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public GetRepositoryListUseCase provideGetRepositoryListUseCase(ProjectsListRepository repository, MapperRepository mapperRepository) {
        return new GetRepositoryListUseCase(repository, mapperRepository);
    }
}
