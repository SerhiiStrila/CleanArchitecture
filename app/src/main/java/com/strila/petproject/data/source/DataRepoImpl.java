package com.strila.petproject.data.source;

import com.strila.petproject.di.scope.ApplicationScope;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 10/1/17
 */

@ApplicationScope
public class DataRepoImpl implements DataRepo {

    private RedditApi network;
    private LocalData db;

    @Inject
    DataRepoImpl(RedditApi redditApi, LocalData localData) {
        network = redditApi;
        db = localData;
    }

}
