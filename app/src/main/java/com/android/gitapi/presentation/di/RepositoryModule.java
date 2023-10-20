package com.android.gitapi.presentation.di;

import com.android.gitapi.data.repository.DataBaseRepositoryImpl;
import com.android.gitapi.data.repository.MapperRepositoryImpl;
import com.android.gitapi.data.repository.ProjectsListRepositoryImpl;
import com.android.gitapi.domain.database.dao.RepositoriesDao;
import com.android.gitapi.domain.network.NetworkApiService;
import com.android.gitapi.domain.repository.DataBaseRepository;
import com.android.gitapi.domain.repository.MapperRepository;
import com.android.gitapi.domain.repository.ProjectsListRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public ProjectsListRepository provideProjectsListRepository(NetworkApiService apiService) {
        return new ProjectsListRepositoryImpl(apiService);
    }

    @Provides
    public MapperRepository provideMapperRepository(MapperRepositoryImpl mapperRepositoryImpl) {
        return mapperRepositoryImpl;
    }

    @Provides
    public DataBaseRepository provideDataBaseRepository(RepositoriesDao repositoriesDao) {
        return new DataBaseRepositoryImpl(repositoriesDao);
    }

}

