package com.android.gitapi.data.repository;

import com.android.gitapi.domain.entity.RepositoryListResponse;
import com.android.gitapi.domain.model.ProjectRequestModel;
import com.android.gitapi.domain.network.NetworkApiService;
import com.android.gitapi.domain.repository.ProjectsListRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class ProjectsListRepositoryImpl implements ProjectsListRepository {

    private NetworkApiService apiService;

    @Inject
    public ProjectsListRepositoryImpl(NetworkApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<RepositoryListResponse> getRepositoryList(ProjectRequestModel model) {
        return apiService.searchRepositories(model.getQuery(), model.getPage(),"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");
    }

}
