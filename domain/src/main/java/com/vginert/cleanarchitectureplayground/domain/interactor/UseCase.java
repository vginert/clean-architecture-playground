/*
 * Copyright (C) 2017 Vicente Giner Tendero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vginert.cleanarchitectureplayground.domain.interactor;

import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Vicente Giner Tendero
 */

abstract class UseCase<T, Params> {

    private final ISubscribeThreadExecutor subscribeThreadExecutor;
    private final IObserverExecutionThread observerExecutionThread;
    private final CompositeDisposable disposables;

    public UseCase(ISubscribeThreadExecutor subscribeThreadExecutor, IObserverExecutionThread observerExecutionThread) {
        this.subscribeThreadExecutor = subscribeThreadExecutor;
        this.observerExecutionThread = observerExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Builds a {@link Observable} which will be used to execute the {@link UseCase} job.
     */
    abstract Observable<T> buildUseCaseObservable(@Nullable Params params);

    /**
     * Executes the {@link UseCase}
     * @param observer {@link DisposableObserver} that observe the use case job
     * @param params Parameters (Optional) used to execute this use case.
     */
    public void execute(@NonNull DisposableObserver<T> observer, @Nullable Params params) {
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(this.subscribeThreadExecutor))
                .observeOn(this.observerExecutionThread.getScheduler());
        this.addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Disposes from {@link CompositeDisposable}
     */
    public void dispose() {
        if(!this.disposables.isDisposed()) {
            this.disposables.dispose();
        }
    }

    /**
     * Add a disposable to {@link CompositeDisposable}
     * @param disposable The disposable to add
     */
    private void addDisposable(@NonNull Disposable disposable) {
        this.disposables.add(disposable);
    }
}
