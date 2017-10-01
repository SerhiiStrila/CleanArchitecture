package com.strila.petproject.di.module;

import com.strila.petproject.data.source.LocalData;
import com.strila.petproject.data.source.LocalDataImpl;
import com.strila.petproject.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Module
public abstract class LocalDataModule {

    @ApplicationScope
    @Binds
    abstract LocalData provideLocalData(LocalDataImpl localData);
}
