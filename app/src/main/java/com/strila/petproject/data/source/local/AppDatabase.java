package com.strila.petproject.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.strila.petproject.data.models.local.Post;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase createDb(Context context) {
        return Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
    }

    public abstract PostDao postModel();

}