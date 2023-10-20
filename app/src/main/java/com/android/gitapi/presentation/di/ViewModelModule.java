package com.android.gitapi.presentation.di;

import com.android.gitapi.domain.di.UseCaseModule;
import com.android.gitapi.domain.usecase.AddFavouriteUseCase;
import com.android.gitapi.domain.usecase.DeleteFavouriteUseCase;
import com.android.gitapi.domain.usecase.GetFavouritesUseCase;
import com.android.gitapi.domain.usecase.GetRepositoryListUseCase;
import com.android.gitapi.presentation.repositorylist.RepositoryListViewModel;
import com.android.gitapi.presentation.repositorylist.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module(includes = UseCaseModule.class)
public class ViewModelModule {

    @Provides
    public ViewModelFactory provideViewModelFactory(RepositoryListViewModel viewModel) {
        return new ViewModelFactory(viewModel);
    }

    @Provides
    public RepositoryListViewModel provideRepositoryListViewModel(GetRepositoryListUseCase getRepositoryListUseCase, GetFavouritesUseCase getFavouritesUseCase, AddFavouriteUseCase addFavouriteUseCase, DeleteFavouriteUseCase deleteFavouriteUseCase) {
        return new RepositoryListViewModel(getRepositoryListUseCase, getFavouritesUseCase, addFavouriteUseCase, deleteFavouriteUseCase);
    }
}

