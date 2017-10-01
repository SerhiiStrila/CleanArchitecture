package com.strila.petproject.data.source.local;

import com.strila.petproject.data.models.local.Post;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Serhii Strila on 10/1/17
 */

public interface LocalData {

    Single<List<Post>> getAllPost();

    void saveAllPost(List<Post> posts);

    void clearAllPost();
}
