package com.strila.petproject.ui.flow2;

import android.os.Bundle;

import com.strila.petproject.R;
import com.strila.petproject.di.base.activity.HasActivitySubComponentBuilders;
import com.strila.petproject.ui.base.BaseActivity;

/**
 * Created by Serhii Strila on 1/11/17
 */

public final class MainActivity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupActivityComponent(HasActivitySubComponentBuilders builders) {
        ((MainActivity2Component.Builder)builders.getActivityComponentBuilder(MainActivity2.class))
                .activity(this)
                .build()
                .inject(this);
    }
}
