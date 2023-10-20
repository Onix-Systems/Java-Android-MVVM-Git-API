package com.android.gitapi.domain.di;


import android.app.Application;

import androidx.room.Room;

import com.android.gitapi.data.database.RepositoriesDataBase;
import com.android.gitapi.domain.database.dao.RepositoriesDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    @Singleton
    public static RepositoriesDataBase provideRepositoryDB(Application application) {
        return Room.databaseBuilder(application, RepositoriesDataBase.class, "Favorite Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static RepositoriesDao provideRepositoriesDao(RepositoriesDataBase repositoriesDataBase) {
        return repositoriesDataBase.repositoriesDao();
    }
}
