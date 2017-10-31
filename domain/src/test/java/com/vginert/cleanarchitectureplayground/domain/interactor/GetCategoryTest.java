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
import com.vginert.cleanarchitectureplayground.domain.repository.ICategoryRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Vicente Giner Tendero
 */
@RunWith(MockitoJUnitRunner.class)
public class GetCategoryTest {

    private static final String FAKE_ID = "sd789a98u9ah9dada9haw";

    private GetCategory getCategory;

    @Mock
    private ISubscribeThreadExecutor subscribeThreadExecutor;
    @Mock
    private IObserverExecutionThread observerExecutionThread;
    @Mock
    private ICategoryRepository categoryRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.getCategory = new GetCategory(this.categoryRepository, this.subscribeThreadExecutor, this.observerExecutionThread);
    }

    @Test
    public void buildUseCaseObservable() throws Exception {
        this.getCategory.buildUseCaseObservable(GetCategory.Params.forCategory(FAKE_ID));
        Mockito.verify(this.categoryRepository).getCategory(FAKE_ID);
        Mockito.verifyNoMoreInteractions(this.categoryRepository);
        Mockito.verifyZeroInteractions(this.subscribeThreadExecutor);
        Mockito.verifyZeroInteractions(this.observerExecutionThread);
    }

    @Test
    public void buildUseCaseObservableEmptyParameters() throws Exception {
        this.expectedException.expect(NullPointerException.class);
        this.getCategory.buildUseCaseObservable(null);
    }

}