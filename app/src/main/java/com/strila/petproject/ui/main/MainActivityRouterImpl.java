package com.strila.petproject.ui.main;

import android.content.Intent;
import android.view.View;

import com.strila.petproject.R;
import com.strila.petproject.di.scope.ActivityScope;
import com.strila.petproject.ui.main.posts.PostListFragment;
import com.strila.petproject.ui.main.preview.PreviewFragment;
import com.strila.petproject.utils.ActivityUtils;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/12/17
 */

@ActivityScope
final class MainActivityRouterImpl implements MainActivityRouter {

    private MainActivity activity;

    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {
        ActivityUtils.replaceFragmentInActivity(activity.getFragmentManager(),
                PostListFragment.newInstance(), false);
    }

    @Override
    public void goToPreview(View view, String imageUrl) {
        ActivityUtils.addFragmentInActivity(activity.getFragmentManager(),
                PreviewFragment.newInstance(imageUrl), true);
    }

    @Override
    public void goToShare(String imageUrl) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, imageUrl);
        activity.startActivity(Intent.createChooser(share, activity.getString(R.string.share_image)));
    }
}