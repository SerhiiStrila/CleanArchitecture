package com.strila.petproject.ui.flow1;

import android.os.Bundle;

import com.strila.petproject.R;
import com.strila.petproject.di.base.activity.HasActivitySubComponentBuilders;
import com.strila.petproject.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 1/11/17
 */

public class MainActivity extends BaseActivity {

    @Inject MainActivityRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent(HasActivitySubComponentBuilders builders) {
        ((MainActivityComponent.Builder)builders.getActivityComponentBuilder(MainActivity.class))
                .activity(this)
                .build()
                .inject(this);
    }
}
