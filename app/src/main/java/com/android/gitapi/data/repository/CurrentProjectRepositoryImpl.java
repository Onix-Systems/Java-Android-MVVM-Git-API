package com.android.gitapi.data.repository;

import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.repository.CurrentProjectRepository;

public class CurrentProjectRepositoryImpl implements CurrentProjectRepository {
    private ProjectItemModel projectItemModel;

    private static CurrentProjectRepositoryImpl instance;

    private CurrentProjectRepositoryImpl() {

    }

    public static CurrentProjectRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CurrentProjectRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void setProject(ProjectItemModel model) {
        this.projectItemModel = model;
    }

    @Override
    public ProjectItemModel getProject() {
        return projectItemModel;
    }
}
