package com.android.gitapi.domain.usecase;


import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.model.ProjectRequestModel;
import com.android.gitapi.domain.model.RepositorySearchResult;
import com.android.gitapi.domain.repository.MapperRepository;
import com.android.gitapi.domain.repository.ProjectsListRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GetRepositoryListUseCase extends BaseUseCase<Observable<RepositorySearchResult>, ProjectRequestModel> {

    private final ProjectsListRepository repository;
    private final MapperRepository mapperRepository;

    @Inject
    public GetRepositoryListUseCase(ProjectsListRepository repository, MapperRepository mapperRepository) {
        this.repository = repository;
        this.mapperRepository = mapperRepository;
    }

    @Override
    protected Observable<RepositorySearchResult> buildUseCaseSingle(ProjectRequestModel params) {
        return repository.getRepositoryList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(repositoryListResponse -> {
                    List<ProjectItemModel> mappedItems = repositoryListResponse.getItems()
                            .stream()
                            .map(entity -> mapperRepository.mapRepositoryToModel(entity))
                            .collect(Collectors.toList());

                    return new RepositorySearchResult(repositoryListResponse.getTotalCount(), mappedItems);
                });
    }
}

