package com.android.gitapi.presentation.di;

import com.android.gitapi.presentation.repositorylist.RepositoryListFragment;

import dagger.Component;

@Component(modules = {ViewModelModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(RepositoryListFragment fragment);
}
