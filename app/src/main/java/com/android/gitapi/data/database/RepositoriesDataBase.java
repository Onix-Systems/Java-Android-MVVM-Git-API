package com.android.gitapi.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.android.gitapi.domain.database.dao.RepositoriesDao;
import com.android.gitapi.domain.database.entity.RepositoryEntity;

@Database(entities = {RepositoryEntity.class}, version = 1, exportSchema = false)
public abstract class RepositoriesDataBase extends RoomDatabase {
    public abstract RepositoriesDao repositoriesDao();
}
