package com.strila.petproject.data.source.network;

import com.strila.petproject.data.models.response.ListingResponse;
import com.strila.petproject.data.models.response.PostResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Serhii Strila on 10/1/17
 */

public interface RedditApi {

    @GET(ApiConstants.TOP_PATH)
    Single<ListingResponse<PostResponse>> getTop(@Query("after") String after,
                                                 @Query("limit") int limit);
}
