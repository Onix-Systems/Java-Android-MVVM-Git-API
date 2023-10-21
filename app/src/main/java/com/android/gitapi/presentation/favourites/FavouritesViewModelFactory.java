package com.android.gitapi.presentation.favourites;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;


public class FavouritesViewModelFactory implements ViewModelProvider.Factory {

    private final FavouritesViewModel viewModel;

    @Inject
    public FavouritesViewModelFactory(FavouritesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FavouritesViewModel.class)) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

