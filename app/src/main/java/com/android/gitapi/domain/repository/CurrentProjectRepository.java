package com.android.gitapi.domain.repository;

import com.android.gitapi.domain.model.ProjectItemModel;

public interface CurrentProjectRepository {
    void setProject(ProjectItemModel model);

    ProjectItemModel getProject();
}
