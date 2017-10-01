package com.strila.petproject.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.strila.petproject.data.models.local.Post;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Dao
public interface PostDao {

    @Query("SELECT * FROM post")
    Single<List<Post>> getAllPosts();

    @Query("DELETE FROM post")
    void deleteAllPosts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosts(List<Post> posts);
}
