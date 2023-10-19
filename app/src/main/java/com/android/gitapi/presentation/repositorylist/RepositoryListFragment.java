package com.android.gitapi.presentation.repositorylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.gitapi.App;
import com.android.gitapi.R;
import com.android.gitapi.databinding.FragmentRepositoryListBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.repository.ProjectsListRepository;
import com.android.gitapi.presentation.adapter.RepositoryAdapter;
import com.android.gitapi.presentation.arch.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class RepositoryListFragment extends BaseFragment<FragmentRepositoryListBinding> {

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    ProjectsListRepository projectsListRepository;

    private final RepositoryAdapter adapter = new RepositoryAdapter();

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

    private void initRecycle() {
        binding.repoRecyclerView.setAdapter(adapter);
        binding.repoRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        var list = new ArrayList<ProjectItemModel>();
        list.add(new ProjectItemModel(1, "Username", "Some description text", 3.4f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIC4VUtRM1OdB1qC2Ybg_cyjVaCWMZ_WLgYaZoTiZZIQ&s"));
        list.add(new ProjectItemModel(1, "Username", "Some description text Some description text Some description text Some description text Some description text Some description text", 3.4f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIC4VUtRM1OdB1qC2Ybg_cyjVaCWMZ_WLgYaZoTiZZIQ&s"));
        list.add(new ProjectItemModel(1, "Username", "Some description text", 3.4f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIC4VUtRM1OdB1qC2Ybg_cyjVaCWMZ_WLgYaZoTiZZIQ&s"));
        list.add(new ProjectItemModel(1, "Username", "Some description text Some description text Some description text Some description text", 3.4f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIC4VUtRM1OdB1qC2Ybg_cyjVaCWMZ_WLgYaZoTiZZIQ&s"));
        adapter.submitList(list);
    }

    private void setupSpinner() {
        String[] timeFrameItems = getResources().getStringArray(R.array.timeframe);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, timeFrameItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.timeframeSpinner.setAdapter(adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_repository_list;
    }

    @Override
    protected void setupViews() {
        initRecycle();
        setupSpinner();
    }

    @Override
    protected void setObservers() {

    }
}