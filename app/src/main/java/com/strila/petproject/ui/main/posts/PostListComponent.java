package com.strila.petproject.ui.main.posts;

import android.app.Fragment;

import com.strila.petproject.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
@Subcomponent
public interface PostListComponent extends AndroidInjector<PostListFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PostListFragment> {

    }

    @Module(subcomponents = PostListComponent.class)
    abstract class PostListModule {

        @Binds
        @IntoMap
        @FragmentKey(PostListFragment.class)
        abstract AndroidInjector.Factory<? extends Fragment>
        bindPostListInjectorFactory(PostListComponent.Builder builder);

        @FragmentScope
        @Binds
        abstract PostListContract.View bindView(PostListFragment fragment);

        @FragmentScope
        @Binds
        abstract PostListContract.Presenter bindPresenter(PostListPresenter presenter);

    }
}
