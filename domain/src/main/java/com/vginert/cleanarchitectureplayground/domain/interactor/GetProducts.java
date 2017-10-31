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

import com.vginert.cleanarchitectureplayground.domain.Product;
import com.vginert.cleanarchitectureplayground.domain.executor.IObserverExecutionThread;
import com.vginert.cleanarchitectureplayground.domain.executor.ISubscribeThreadExecutor;
import com.vginert.cleanarchitectureplayground.domain.repository.IProductRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Vicente Giner Tendero
 *         <p>
 *         Represents a use case for retrieving a list of all {@link Product}.
 */

public class GetProducts extends UseCase<List<Product>, Void> {

    private final IProductRepository productRepository;

    @Inject
    public GetProducts(IProductRepository productRepository, ISubscribeThreadExecutor subscribeThreadExecutor, IObserverExecutionThread observerExecutionThread) {
        super(subscribeThreadExecutor, observerExecutionThread);
        this.productRepository = productRepository;
    }

    @Override
    Observable<List<Product>> buildUseCaseObservable(Void unused) {
        return this.productRepository.getProducts();
    }
}
