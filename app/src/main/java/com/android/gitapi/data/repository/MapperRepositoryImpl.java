package com.android.gitapi.data.repository;

import com.android.gitapi.domain.network.entity.RepositorySearchResponse;
import com.android.gitapi.domain.model.ProjectItemModel;
import com.android.gitapi.domain.repository.MapperRepository;

import javax.inject.Inject;

public class MapperRepositoryImpl implements MapperRepository {

    @Inject
    public MapperRepositoryImpl() {

    }

    @Override
    public ProjectItemModel mapRepositoryToModel(RepositorySearchResponse entity) {
        return new ProjectItemModel(entity.getId(), entity.getOwner().getLogin(), entity.getDescription(), String.valueOf(entity.getStargazersCount()), entity.getOwner().getAvatarUrl(), entity.getName(), entity.getCreatedAt(), entity.getLanguage(), entity.getForks(), entity.getHtmlUrl());
    }
}
