package com.strila.petproject.di.module;

import com.strila.petproject.data.source.repo.DataRepo;
import com.strila.petproject.data.source.repo.DataRepoImpl;
import com.strila.petproject.di.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Module
public abstract class RepoModule {

    @ApplicationScope
    @Binds
    abstract DataRepo provideRepo(DataRepoImpl repo);
}
