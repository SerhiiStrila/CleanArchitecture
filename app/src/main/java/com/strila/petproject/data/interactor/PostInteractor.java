package com.strila.petproject.data.interactor;

import com.strila.petproject.data.source.DataRepo;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 10/1/17
 */

public final class PostInteractor {

    @Inject DataRepo repo;

    @Inject
    PostInteractor() {

    }
}
