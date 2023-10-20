package com.android.gitapi.data.repository;

import androidx.lifecycle.LiveData;

import com.android.gitapi.domain.database.dao.RepositoriesDao;
import com.android.gitapi.domain.database.entity.RepositoryEntity;
import com.android.gitapi.domain.repository.DataBaseRepository;

import java.util.List;

import javax.inject.Inject;

public class DataBaseRepositoryImpl implements DataBaseRepository {

    private RepositoriesDao repositoriesDao;


    @Inject
    public DataBaseRepositoryImpl(RepositoriesDao repositoriesDao) {
        this.repositoriesDao = repositoriesDao;
    }

    @Override
    public List<RepositoryEntity> getFavourites() {
        return repositoriesDao.getFavoriteRepositories();
    }

    @Override
    public void insertRepository(RepositoryEntity entity) {
        repositoriesDao.insertRepository(entity);
    }

    @Override
    public void deleteRepository(String repoName) {
        repositoriesDao.deleteRepository(repoName);
    }

    @Override
    public void deleteAll() {
        repositoriesDao.deleteAll();
    }
}
