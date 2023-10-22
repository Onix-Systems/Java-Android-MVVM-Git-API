package com.android.gitapi.presentation.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.gitapi.App;
import com.android.gitapi.R;
import com.android.gitapi.data.repository.CurrentProjectRepositoryImpl;
import com.android.gitapi.databinding.FragmentFavouritesBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.presentation.adapter.RepositoryAdapter;
import com.android.gitapi.presentation.arch.BaseFragment;
import com.android.gitapi.presentation.arch.Command;
import com.android.gitapi.presentation.repositorylist.RepositoryItemPresenter;
import com.android.gitapi.presentation.tablayout.TabLayoutRepository;

import javax.inject.Inject;

public class FavouritesFragment extends BaseFragment<FragmentFavouritesBinding> implements RepositoryItemPresenter {

    private RepositoryAdapter adapter = new RepositoryAdapter(this);

    @Inject
    FavouritesViewModelFactory viewModelFactory;


    private FavouritesViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(FavouritesViewModel.class);
        binding.setViewModel(viewModel);
        initRecycle();
        viewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            adapter.submitList(items);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.fetchFavourites();
    }

    @Override
    public void onStart() {
        super.onStart();
        TabLayoutRepository.getInstance().setIsShowTabLayoutEvent(true);
    }

    private void initRecycle() {
        binding.repoRecyclerView.setAdapter(adapter);
        binding.repoRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favourites;
    }

    @Override
    protected void setupViews() {
    }

    @Override
    protected void setObservers() {

    }

    @Override
    public void onFavouriteClick(ProjectItemModel projectItemModel) {
        viewModel.onFavouriteClick(projectItemModel);
    }

    @Override
    public void onItemClick(ProjectItemModel projectItemModel) {
        CurrentProjectRepositoryImpl.getInstance().setProject(projectItemModel);
        navigate(new Command.Route(FavouritesFragmentDirections.actionFavouritesFragmentToDetailsFragment2()));
    }
}