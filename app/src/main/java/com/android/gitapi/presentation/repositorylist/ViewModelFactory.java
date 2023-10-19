package com.android.gitapi.presentation.repositorylist;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final RepositoryListViewModel viewModel;

    @Inject
    public ViewModelFactory(RepositoryListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RepositoryListViewModel.class)) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

