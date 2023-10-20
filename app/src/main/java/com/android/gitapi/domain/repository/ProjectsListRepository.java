package com.android.gitapi.domain.repository;

import com.android.gitapi.domain.entity.RepositoryListResponse;
import com.android.gitapi.domain.model.ProjectRequestModel;

import io.reactivex.rxjava3.core.Observable;

public interface ProjectsListRepository {
    Observable<RepositoryListResponse> getRepositoryList(ProjectRequestModel model);
}
