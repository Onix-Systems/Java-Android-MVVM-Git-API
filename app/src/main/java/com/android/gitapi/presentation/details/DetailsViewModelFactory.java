package com.android.gitapi.presentation.details;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

public class DetailsViewModelFactory implements ViewModelProvider.Factory {

    private final DetailsViewModel viewModel;

    @Inject
    public DetailsViewModelFactory(DetailsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailsViewModel.class)) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

