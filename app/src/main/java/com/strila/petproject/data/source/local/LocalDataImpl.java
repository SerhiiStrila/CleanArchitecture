package com.strila.petproject.data.source.local;

import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.di.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Serhii Strila on 10/1/17
 */

@ApplicationScope
public class LocalDataImpl implements LocalData {

    private PostDao postDao;

    @Inject
    LocalDataImpl(PostDao dao) {
        postDao = dao;
    }

    @Override
    public Single<List<Post>> getAllPost() {
        return postDao.getAllPosts();
    }

    @Override
    public void saveAllPost(List<Post> posts) {
        postDao.insertPosts(posts);
    }

    @Override
    public void clearAllPost() {
        postDao.deleteAllPosts();
    }
}