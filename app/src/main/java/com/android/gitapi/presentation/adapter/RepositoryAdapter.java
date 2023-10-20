package com.android.gitapi.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.android.gitapi.databinding.RepositoryItemBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.presentation.repositorylist.RepositoryItemPresenter;

public class RepositoryAdapter extends ListAdapter<ProjectItemModel, RepositoryViewHolder> {

    private RepositoryItemPresenter presenter;

    public RepositoryAdapter(RepositoryItemPresenter presenter) {
        super(new RepositoryDiffCallback());
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RepositoryItemBinding binding = RepositoryItemBinding.inflate(inflater, parent, false);
        return new RepositoryViewHolder(binding, presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        ProjectItemModel repository = getItem(position);
        holder.bind(repository);
    }

}