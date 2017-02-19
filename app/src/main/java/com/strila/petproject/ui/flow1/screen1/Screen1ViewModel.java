package com.strila.petproject.ui.flow1.screen1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.strila.petproject.BR;
import com.strila.petproject.di.base.fragment.FragmentScope;

import javax.inject.Inject;

/**
 * Created by Serhii Strila on 2/2/17
 */

@FragmentScope
public final class Screen1ViewModel extends BaseObservable implements Fragment1Contract.View {

    private boolean check = true;

    @Inject
    Screen1ViewModel() {
    }

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
