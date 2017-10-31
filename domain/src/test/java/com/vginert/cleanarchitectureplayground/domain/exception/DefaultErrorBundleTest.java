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

package com.vginert.cleanarchitectureplayground.domain.exception;

import org.assertj.core.api.Assertions;
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
public class DefaultErrorBundleTest {

    private DefaultErrorBundle defaultErrorBundle;
    @Mock
    private Exception mockException;

    @Before
    public void setUp() {
        defaultErrorBundle = new DefaultErrorBundle(mockException);
    }

    @Test
    public void getException() throws Exception {
        Exception exception = this.defaultErrorBundle.getException();
        Assertions.assertThat(exception).isEqualTo(this.mockException);
    }

    @Test
    public void getErrorMessage() throws Exception {
        this.defaultErrorBundle.getErrorMessage();
        Mockito.verify(this.mockException).getMessage();
    }

}