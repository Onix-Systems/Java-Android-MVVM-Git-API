package com.android.gitapi.presentation.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.android.gitapi.databinding.RepositoryItemBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.bumptech.glide.Glide;


public class RepositoryViewHolder extends RecyclerView.ViewHolder {
    private final RepositoryItemBinding binding;

    public RepositoryViewHolder(RepositoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ProjectItemModel repository) {
        binding.setModel(repository);
        binding.executePendingBindings();
        Glide.with(binding.getRoot()).load(repository.getAvatarUrl()).into(binding.avatarImageView);
    }
}

