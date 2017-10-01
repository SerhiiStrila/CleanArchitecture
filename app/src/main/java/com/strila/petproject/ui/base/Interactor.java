package com.strila.petproject.ui.base;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Serhii Strila on 10/1/17
 */

public abstract class Interactor {

    private final FlowableTransformer<Object, Object> flowableTransformer;
    private final ObservableTransformer<Object, Object> observableTransformer;
    private final SingleTransformer<Object, Object> singleTransformer;
    private final CompletableTransformer completableTransformer;
    private final MaybeTransformer<Object, Object> maybeTransformer;

    public Interactor() {
        this(Schedulers.io(), AndroidSchedulers.mainThread());
    }

    public Interactor(Scheduler workerThreadScheduler, Scheduler uiThreadScheduler) {
        this.flowableTransformer = observable -> observable.subscribeOn(workerThreadScheduler)
                .observeOn(uiThreadScheduler);
        this.observableTransformer = observable -> observable.subscribeOn(workerThreadScheduler)
                .observeOn(uiThreadScheduler);
        this.singleTransformer = observable -> observable.subscribeOn(workerThreadScheduler)
                .observeOn(uiThreadScheduler);
        this.completableTransformer = observable -> observable.subscribeOn(workerThreadScheduler)
                .observeOn(uiThreadScheduler);
        this.maybeTransformer = single -> single.subscribeOn(workerThreadScheduler)
                .observeOn(uiThreadScheduler);
    }

    @SuppressWarnings("unchecked")
    public <T> FlowableTransformer<T, T> applySchedulersToFlowable() {
        return (FlowableTransformer<T, T>) flowableTransformer;
    }

    @SuppressWarnings("unchecked")
    public <T> ObservableTransformer<T, T> applySchedulersToObservable() {
        return (ObservableTransformer<T, T>) observableTransformer;
    }

    @SuppressWarnings("unchecked")
    public <T> SingleTransformer<T, T> applySchedulersToSingle() {
        return (SingleTransformer<T, T>) singleTransformer;
    }

    @SuppressWarnings("unchecked")
    public CompletableTransformer applySchedulersToCompletable() {
        return completableTransformer;
    }

    @SuppressWarnings("unchecked")
    public <T> MaybeTransformer<T, T> applySchedulersToMaybe() {
        return (MaybeTransformer<T, T>) maybeTransformer;
    }

}