package com.strila.petproject.ui.flow1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import com.strila.petproject.R;
import com.strila.petproject.di.base.activity.ActivityScope;
import com.strila.petproject.ui.flow1.screen1.Fragment1;
import com.strila.petproject.ui.flow2.MainActivity2;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/12/17
 */

@ActivityScope
final class MainActivityRouterImpl implements MainActivityRouter {

    private MainActivity mActivity;

    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        mActivity = activity;
        baseInit();
    }


    @Override
    public void goNext() {
        mActivity.startActivity(new Intent(mActivity, MainActivity2.class));
    }

    private void baseInit() {
        FragmentManager fm = mActivity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, Fragment1.newInstance(), Fragment1.class.getName());
        ft.commit();
    }
}
