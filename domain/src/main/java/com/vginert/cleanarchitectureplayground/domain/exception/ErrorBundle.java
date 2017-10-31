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
 *         Exception warpper that represents a error
 */

public interface ErrorBundle {

    /**
     * Get the base exception that produces the error
     * @return The exception
     */
    Exception getException();

    /**
     * Get the error message from the error
     * @return The error message
     */
    String getErrorMessage();
}
