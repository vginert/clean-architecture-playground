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

package com.vginert.cleanarchitectureplayground.android.di.component;

import android.content.Context;

import com.vginert.cleanarchitectureplayground.android.di.module.ApplicationModule;
import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Vicente Giner Tendero
 *
 * A component whose lifetime is the application lifetime
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();
    ISubscribeThreadExecutor subscribeThreadExecutor();
    IObserverExecutionThread observerExecutionThread();
}
