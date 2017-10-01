package com.strila.petproject.ui.main.preview;

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
public interface PreviewComponent extends AndroidInjector<PreviewFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PreviewFragment> {

    }

    @Module(subcomponents = PreviewComponent.class)
    abstract class PreviewModule {

        @FragmentScope
        @Binds
        abstract PreviewContract.View bindView(PreviewFragment fragment);

        @FragmentScope
        @Binds
        public abstract PreviewContract.Presenter bindPresenter(PreviewPresenter presenter);

        @Binds
        @IntoMap
        @FragmentKey(PreviewFragment.class)
        abstract AndroidInjector.Factory<? extends Fragment>
        bindPreviewInjectorFactory(PreviewComponent.Builder builder);

    }
}
