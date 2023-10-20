package com.android.gitapi.presentation.di;

import com.android.gitapi.domain.di.ApiModule;
import com.android.gitapi.domain.di.DataBaseModule;
import com.android.gitapi.domain.di.UseCaseModule;
import com.android.gitapi.presentation.repositorylist.RepositoryListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModelModule.class, RepositoryModule.class, ApiModule.class, UseCaseModule.class, DataBaseModule.class, AppModule.class})
public interface AppComponent {
    void inject(RepositoryListFragment fragment);
}
