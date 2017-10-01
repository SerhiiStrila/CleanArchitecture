package com.strila.petproject.ui.flow1.screen2;

import android.support.annotation.NonNull;

import com.strila.petproject.data.interactor.PostInteractor;
import com.strila.petproject.data.models.User;
import com.strila.petproject.di.scope.FragmentScope;
import com.strila.petproject.ui.base.BasePresenter;
import com.strila.petproject.ui.flow1.MainActivityRouter;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Serhii Strila on 1/11/17
 */

@FragmentScope
public final class Fragment2Presenter extends BasePresenter<Fragment2Contract.View, MainActivityRouter>
        implements Fragment2Contract.Presenter {

    @Inject PostInteractor postInteractor;

    @Inject
    Fragment2Presenter(@NonNull Fragment2Contract.View view, @NonNull MainActivityRouter router) {
        super(view, router);
    }

    @Override
    public void next() {
        router.goNext();
    }

    @Override
    public void loadMore() {
        mDisposables.add(Observable.range(0, 10)
                .map(num -> generateUser())
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showLoading(true))
                .doOnNext(user -> view.showLoading(false))
                .subscribe(user -> view.addUser(user), Throwable::printStackTrace));
    }

    // FIXME: 4/6/17 Create Repository and move it
    private User generateUser() {
        Random random = new Random();
        return User.builder()
                .id(random.nextInt(100))
                .name("Test User" + random.nextInt(1000))
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
    }
}
