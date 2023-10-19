package com.android.gitapi.presentation.di;

import com.android.gitapi.data.repository.ProjectsListRepositoryImpl;
import com.android.gitapi.domain.repository.ProjectsListRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    public ProjectsListRepository provideProjectsListRepository() {
        return new ProjectsListRepositoryImpl();
    }
}
