package com.strila.petproject.data.source.repo;

import com.strila.petproject.data.models.local.Pagination;
import com.strila.petproject.data.models.local.Post;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Serhii Strila on 10/1/17
 */

public interface DataRepo {

    Single<List<Post>> updateTop(Pagination pagination, int limit);

    Single<List<Post>> reloadTop(Pagination pagination, int limit);

    Single<List<Post>> getTop();
}
