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
import com.vginert.cleanarchitectureplayground.domain.Product;
import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;
import com.vginert.cleanarchitectureplayground.domain.repository.ICategoryRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Vicente Giner Tendero
 *         <p>
 *         Represents a use case for retrieving data related to an specific {@link Product}.
 */

public class GetCategory extends UseCase<Category, GetCategory.Params> {

    private final ICategoryRepository categoryRepository;

    @Inject
    public GetCategory(ICategoryRepository categoryRepository, ISubscribeThreadExecutor subscribeThreadExecutor, IObserverExecutionThread observerExecutionThread) {
        super(subscribeThreadExecutor, observerExecutionThread);
        this.categoryRepository = categoryRepository;
    }

    @Override
    Observable<Category> buildUseCaseObservable(Params params) {
        return this.categoryRepository.getCategory(params.id);
    }

    public static final class Params {

        private final String id;

        private Params(String id) {
            this.id = id;
        }

        public static Params forCategory(String id) {
            return new Params(id);
        }
    }
}
