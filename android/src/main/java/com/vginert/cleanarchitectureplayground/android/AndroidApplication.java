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

package com.vginert.cleanarchitectureplayground.android;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.vginert.cleanarchitectureplayground.android.di.HasComponent;
import com.vginert.cleanarchitectureplayground.android.di.component.ApplicationComponent;
import com.vginert.cleanarchitectureplayground.android.di.component.DaggerApplicationComponent;
import com.vginert.cleanarchitectureplayground.android.di.module.ApplicationModule;

/**
 * @author Vicente Giner Tendero
 *
 * Main application class
 */

public class AndroidApplication extends Application implements HasComponent<ApplicationComponent> {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        this.setupLeakCanary();
        this.setupDependencyInjector();
    }

    protected void setupDependencyInjector() {
        this.component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    @Override
    public ApplicationComponent getComponent() {
        return component;
    }
}