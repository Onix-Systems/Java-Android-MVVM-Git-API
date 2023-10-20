package com.android.gitapi.presentation.repositorylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.gitapi.App;
import com.android.gitapi.R;
import com.android.gitapi.data.model.TimePeriod;
import com.android.gitapi.databinding.FragmentRepositoryListBinding;
import com.android.gitapi.domain.model.ProjectRequestModel;
import com.android.gitapi.domain.repository.ProjectsListRepository;
import com.android.gitapi.presentation.adapter.RepositoryAdapter;
import com.android.gitapi.presentation.arch.BaseFragment;

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
        viewModel.getRepositoryListLiveData().observe(getViewLifecycleOwner(), items -> {
            adapter.submitList(items);
            adapter.notifyDataSetChanged();
        });
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initRecycle() {
        binding.repoRecyclerView.setAdapter(adapter);
        binding.repoRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        binding.repoRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition;

                if (layoutManager instanceof LinearLayoutManager) {
                    firstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else {
                    firstVisibleItemPosition = 0;
                }

                if (!viewModel.isLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItemPosition)) {
                    viewModel.loadNextPage();
                }
            }
        });
    }


    private void setupSpinner() {
        String[] timeFrameItems = getResources().getStringArray(R.array.timeframe);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, timeFrameItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.timeframeSpinner.setAdapter(adapter);
        binding.timeframeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TimePeriod selectedTimePeriod = getTimePeriodForPosition(position);
                viewModel.setTimePeriod(selectedTimePeriod);
                viewModel.setCurrentPage(1);
                viewModel.fetchRepositoryList(new ProjectRequestModel(viewModel.parseQueryDate(viewModel.getTimePeriod()), String.valueOf(viewModel.getCurrentPage())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private TimePeriod getTimePeriodForPosition(int position) {
        switch (position) {
            case 0:
                return TimePeriod.LAST_DAY;
            case 1:
                return TimePeriod.LAST_WEEK;
            case 2:
                return TimePeriod.LAST_MONTH;
            default:
                return TimePeriod.LAST_DAY;
        }
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