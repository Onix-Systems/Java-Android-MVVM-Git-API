package com.android.gitapi.presentation.di;

import com.android.gitapi.presentation.repositorylist.RepositoryListViewModel;
import com.android.gitapi.presentation.repositorylist.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Provides
    public ViewModelFactory provideViewModelFactory(RepositoryListViewModel viewModel) {
        return new ViewModelFactory(viewModel);
    }

    @Provides
    public RepositoryListViewModel provideRepositoryListViewModel() {
        return new RepositoryListViewModel();
    }
}
