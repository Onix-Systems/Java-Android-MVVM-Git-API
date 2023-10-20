package com.android.gitapi.presentation.adapter;



import androidx.recyclerview.widget.RecyclerView;

import com.android.gitapi.R;
import com.android.gitapi.databinding.RepositoryItemBinding;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.presentation.listeners.RepositoryItemController;
import com.android.gitapi.presentation.repositorylist.RepositoryItemPresenter;
import com.bumptech.glide.Glide;


public class RepositoryViewHolder extends RecyclerView.ViewHolder implements RepositoryItemController {
    private final RepositoryItemBinding binding;
    private final RepositoryItemPresenter presenter;


    public RepositoryViewHolder(RepositoryItemBinding binding, RepositoryItemPresenter presenter) {
        super(binding.getRoot());
        this.binding = binding;
        this.presenter = presenter;
    }

    public void bind(ProjectItemModel repository) {
        binding.setModel(repository);
        binding.setController(this);
        binding.executePendingBindings();
        binding.itemCamerasFavorite.setChecked(repository.isFavourite());
        Glide.with(binding.getRoot())
                .load(repository.getAvatarUrl())
                .placeholder(R.drawable.default_user_image)
                .into(binding.avatarImageView);
    }

    @Override
    public void onFavouriteClick() {
        presenter.onFavouriteClick(binding.getModel());
    }

    @Override
    public void onItemClick() {
        presenter.onItemClick(binding.getModel());
    }
}

