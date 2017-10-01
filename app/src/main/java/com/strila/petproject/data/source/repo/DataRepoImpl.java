package com.strila.petproject.data.source.repo;

import com.strila.petproject.data.models.local.Pagination;
import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.data.models.mapper.PostMapper;
import com.strila.petproject.data.models.response.ListingResponse;
import com.strila.petproject.data.source.local.LocalData;
import com.strila.petproject.data.source.network.RedditApi;
import com.strila.petproject.di.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

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

    @Override
    public Single<List<Post>> updateTop(Pagination pagination, int limit) {
        return network.getTop(pagination.getAfter(), limit)
                .map(ListingResponse::getData)
                .doOnSuccess(res -> pagination.setAfter(res.getAfter()))
                .map(ListingResponse.PaginationData::getDataList)
                .flatMapObservable(Observable::fromIterable)
                .map(ListingResponse.Data::getData)
                .map(PostMapper::map)
                .toList()
                .doOnSuccess(posts -> db.saveAllPost(posts));
    }

    @Override
    public Single<List<Post>> reloadTop(Pagination pagination, int limit) {
        return network.getTop(pagination.getAfter(), limit)
                .map(ListingResponse::getData)
                .doOnSuccess(res -> pagination.setAfter(res.getAfter()))
                .map(ListingResponse.PaginationData::getDataList)
                .flatMapObservable(Observable::fromIterable)
                .map(ListingResponse.Data::getData)
                .map(PostMapper::map)
                .toList()
                .doOnSuccess(posts -> {
                    db.clearAllPost();
                    db.saveAllPost(posts);
                });
    }

    @Override
    public Single<List<Post>> getTop() {
        return db.getAllPost();
    }

}
