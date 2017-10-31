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

/**
 * @author Vicente Giner Tendero
 *         <p>
 *         Exception warpper used to manage default errors
 */

public class DefaultErrorBundle implements ErrorBundle {

    private final static String DEFAULT_MESSAGE = "Unknown error";

    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return this.exception;
    }

    @Override
    public String getErrorMessage() {
        return (this.exception != null) ? this.exception.getMessage() : DEFAULT_MESSAGE;
    }
}
