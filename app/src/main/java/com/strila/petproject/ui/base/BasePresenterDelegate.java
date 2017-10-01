package com.strila.petproject.ui.base;

import android.os.Bundle;

/**
 * Created by Serhii Strila on 1/11/17
 */

public interface BasePresenterDelegate {

    void attach();

    void detach();

    void saveState(Bundle savedInstanceState);

    void restoreState(Bundle savedInstanceState);

}