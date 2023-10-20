package com.android.gitapi.presentation.repositorylist;

import com.android.gitapi.domain.model.ProjectItemModel;

public interface RepositoryItemPresenter {
    void onFavouriteClick(ProjectItemModel projectItemModel);

    void onItemClick(ProjectItemModel projectItemModel);
}
