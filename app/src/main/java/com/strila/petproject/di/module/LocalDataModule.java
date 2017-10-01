package com.strila.petproject.di.module;

import android.content.Context;

import com.strila.petproject.data.source.local.AppDatabase;
import com.strila.petproject.data.source.local.LocalData;
import com.strila.petproject.data.source.local.LocalDataImpl;
import com.strila.petproject.data.source.local.PostDao;
import com.strila.petproject.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Module
public abstract class LocalDataModule {

    @ApplicationScope
    @Provides
    static AppDatabase provideDatabase(Context context) {
        return AppDatabase.createDb(context);
    }

    @ApplicationScope
    @Provides
    static PostDao provideUserDao(AppDatabase db) {
        return db.postModel();
    }

    @ApplicationScope
    @Binds
    abstract LocalData provideLocalData(LocalDataImpl localData);

}
