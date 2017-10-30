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

package com.vginert.cleanarchitectureplayground.android.di.module;

import android.content.Context;

import com.vginert.cleanarchitectureplayground.android.AndroidApplication;
import com.vginert.cleanarchitectureplayground.android.AndroidUIThread;
import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;
import com.vginert.cleanarchitectureplayground.executor.JobExecutor;
import com.vginert.cleanarchitectureplayground.net.ISupermarketApi;
import com.vginert.cleanarchitectureplayground.net.SupermarketApiFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Vicente Giner Tendero
 *         <p>
 *         Module that provide objects with the aplication lifetime
 */

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ISubscribeThreadExecutor provideSubscribeThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    IObserverExecutionThread provideObserverExecutionThread(AndroidUIThread androidUIThread) {
        return androidUIThread;
    }

    @Provides
    @Singleton
    ISupermarketApi provideSupermarketApi(SupermarketApiFactory supermarketApiFactory) {
        return supermarketApiFactory.create();
    }
}
