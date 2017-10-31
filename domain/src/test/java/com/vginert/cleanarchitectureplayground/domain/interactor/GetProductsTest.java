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
import com.vginert.cleanarchitectureplayground.domain.repository.IProductRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Vicente Giner Tendero
 */
@RunWith(MockitoJUnitRunner.class)
public class GetProductsTest {

    private GetProducts getProducts;

    @Mock
    private IObserverExecutionThread observerExecutionThread;
    @Mock
    private ISubscribeThreadExecutor subscribeThreadExecutor;
    @Mock
    private IProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        this.getProducts = new GetProducts(this.productRepository, this.subscribeThreadExecutor, this.observerExecutionThread);
    }

    @Test
    public void buildUseCaseObservable() throws Exception {
        this.getProducts.buildUseCaseObservable(null);
        Mockito.verify(this.productRepository).getProducts();
        Mockito.verifyNoMoreInteractions(this.productRepository);
        Mockito.verifyZeroInteractions(this.subscribeThreadExecutor);
        Mockito.verifyZeroInteractions(this.observerExecutionThread);
    }

}