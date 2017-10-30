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

package com.vginert.cleanarchitectureplayground.domain.repository;

import com.vginert.cleanarchitectureplayground.domain.Product;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Vicente Giner Tendero
 */

public interface IProductRepository {

    Observable<List<Product>> getProductsFromCategory(final String categoryId);

    Observable<List<Product>> getProducts();

    Observable<Product> getProduct(final String id);
}
