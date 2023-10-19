package com.android.gitapi.presentation.repositorylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.android.gitapi.App;
import com.android.gitapi.R;
import com.android.gitapi.databinding.FragmentRepositoryListBinding;
import com.android.gitapi.domain.repository.ProjectsListRepository;
import com.android.gitapi.presentation.arch.BaseFragment;

import javax.inject.Inject;

public class RepositoryListFragment extends BaseFragment<FragmentRepositoryListBinding> {

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    ProjectsListRepository projectsListRepository;

    private RepositoryListViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(RepositoryListViewModel.class);
        binding.setViewModel(viewModel);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((App) requireActivity().getApplication()).getAppComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_repository_list;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void setObservers() {

    }
}