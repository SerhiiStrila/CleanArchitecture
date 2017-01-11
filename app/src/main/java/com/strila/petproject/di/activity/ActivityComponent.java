package com.strila.petproject.di.activity;

import android.app.Activity;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface ActivityComponent<A extends Activity> {

    void inject(A activity);
}
