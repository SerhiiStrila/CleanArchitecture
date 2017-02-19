package com.strila.petproject.ui.flow1.screen1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.strila.petproject.BR;

/**
 * Created by Serhii Strila on 2/2/17
 */

public class Screen1ViewModel extends BaseObservable implements Fragment1Contract.View {

    private boolean check = true;

    @Bindable
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }

    @Override
    public void showText() {
        setCheck(true);
    }
}
