package com.android.gitapi.domain.repository;

import com.android.gitapi.domain.database.entity.RepositoryEntity;

import java.util.List;

public interface DataBaseRepository {
    List<RepositoryEntity> getFavourites();

    void insertRepository(RepositoryEntity entity);

    void deleteRepository(String repoName);

    void deleteAll();
}
