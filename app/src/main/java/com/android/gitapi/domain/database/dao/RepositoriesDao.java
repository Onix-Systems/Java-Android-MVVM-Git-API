package com.android.gitapi.domain.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.gitapi.domain.database.entity.RepositoryEntity;

import java.util.List;

@Dao
public interface RepositoriesDao {

    @Insert
    void insertRepository(RepositoryEntity pokemon);

    @Query("DELETE FROM repository_table WHERE repositoryName = :repositoryName")
    void deleteRepository(String repositoryName);

    @Query("DELETE FROM repository_table")
    void deleteAll();

    @Query("SELECT * FROM repository_table")
    List<RepositoryEntity> getFavoriteRepositories();
}
