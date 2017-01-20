package com.strila.petproject.activity.activity1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import com.strila.petproject.R;
import com.strila.petproject.activity.activity2.MainActivity2;
import com.strila.petproject.fragment.fragment1.Fragment1;

/**
 * Created by Serhii Strila on 1/12/17
 */

final class MainActivityRouterImpl implements MainActivityRouter {

    private MainActivity mActivity;

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
