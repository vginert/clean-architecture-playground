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

import com.vginert.cleanarchitectureplayground.domain.Category;
import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;
import com.vginert.cleanarchitectureplayground.domain.repository.ICategoryRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Vicente Giner Tendero
 *         <p>
 *         Represents a use case for retrieving a list of all {@link Category}.
 */

public class GetCategories extends UseCase<List<Category>, Void> {

    private final ICategoryRepository categoryRepository;

    @Inject
    public GetCategories(ICategoryRepository categoryRepository, ISubscribeThreadExecutor subscribeThreadExecutor, IObserverExecutionThread observerExecutionThread) {
        super(subscribeThreadExecutor, observerExecutionThread);
        this.categoryRepository = categoryRepository;
    }

    @Override
    Observable<List<Category>> buildUseCaseObservable(Void unused) {
        return this.categoryRepository.getCategories();
    }
}
