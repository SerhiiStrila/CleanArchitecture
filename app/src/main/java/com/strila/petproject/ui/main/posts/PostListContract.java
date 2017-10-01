package com.strila.petproject.ui.main.posts;

import com.strila.petproject.data.models.local.Post;
import com.strila.petproject.ui.base.BasePresenterDelegate;
import com.strila.petproject.ui.base.BaseViewDelegate;

import java.util.List;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface PostListContract {

    interface View extends BaseViewDelegate {

        void addPosts(List<Post> posts);

        void setPosts(List<Post> posts);

        void showLoading(boolean loading);

    }

    interface Presenter extends BasePresenterDelegate {

        void loadMore();

        void reload();

        void showImage(android.view.View view, String imageUrl);

    }

}
