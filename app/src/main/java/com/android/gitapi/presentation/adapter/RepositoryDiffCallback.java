package com.android.gitapi.presentation.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.android.gitapi.domain.model.ProjectItemModel;

public class RepositoryDiffCallback extends DiffUtil.ItemCallback<ProjectItemModel> {

    @Override
    public boolean areItemsTheSame(@NonNull ProjectItemModel oldItem, @NonNull ProjectItemModel newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }

    @Override
    public boolean areContentsTheSame(@NonNull ProjectItemModel oldItem, @NonNull ProjectItemModel newItem) {
        return oldItem.equals(newItem);
    }
}
