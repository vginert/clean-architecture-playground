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

package com.vginert.cleanarchitectureplayground.executor;

import android.support.annotation.NonNull;

import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * @author Vicente Giner Tendero
 */

public class JobExecutor implements ISubscribeThreadExecutor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAXIMUM_POOL_SIZE = 5;
    private static final long KEEP_ALIVE_TIME = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    JobExecutor() {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = new JobExecutorThreadFactory();
        this.threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
                blockingQueue, threadFactory);
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobExecutorThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_" + counter++);
        }
    }
}
