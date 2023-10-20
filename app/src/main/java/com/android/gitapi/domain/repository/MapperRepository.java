package com.android.gitapi.domain.repository;

import com.android.gitapi.domain.network.entity.RepositorySearchResponse;
import com.android.gitapi.domain.model.ProjectItemModel;

public interface MapperRepository {
    ProjectItemModel mapRepositoryToModel(RepositorySearchResponse entity);
}
