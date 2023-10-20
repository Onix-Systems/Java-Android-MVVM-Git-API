package com.android.gitapi.presentation.adapter;


import androidx.recyclerview.widget.RecyclerView;

import com.android.gitapi.databinding.RepositoryItemBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.presentation.listeners.FavouriteClickListener;
import com.bumptech.glide.Glide;


public class RepositoryViewHolder extends RecyclerView.ViewHolder {
    private final RepositoryItemBinding binding;
    private FavouriteClickListener clickListener;


    public RepositoryViewHolder(RepositoryItemBinding binding, FavouriteClickListener clickListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.clickListener = clickListener;

        binding.itemCamerasFavorite.setOnClickListener(view -> {
            if (clickListener != null) {
                clickListener.onFavouriteClick(binding.getModel());
            }
        });
    }

    public void bind(ProjectItemModel repository) {
        binding.setModel(repository);
        binding.executePendingBindings();
        binding.itemCamerasFavorite.setChecked(repository.isFavourite());
        Glide.with(binding.getRoot()).load(repository.getAvatarUrl()).into(binding.avatarImageView);
    }
}

