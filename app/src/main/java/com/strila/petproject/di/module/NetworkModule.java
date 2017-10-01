package com.strila.petproject.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.strila.petproject.BuildConfig;
import com.strila.petproject.data.source.RedditApi;
import com.strila.petproject.di.scope.ApplicationScope;
import com.strila.petproject.utils.DateConverter;

import java.util.Date;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Serhii Strila on 10/1/17
 */

@Module
public abstract class NetworkModule {

    @ApplicationScope
    @Provides
    static RedditApi provideApi(Retrofit retrofit) {
        return retrofit.create(RedditApi.class);
    }

    @ApplicationScope
    @Provides
    static Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .client(client)
                .build();
    }

    @ApplicationScope
    @Provides
    static OkHttpClient provideOkClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @ApplicationScope
    @Provides
    static Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateConverter())
                .create();
    }
}
