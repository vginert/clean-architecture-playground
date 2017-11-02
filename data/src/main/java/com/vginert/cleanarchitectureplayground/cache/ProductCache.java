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

package com.vginert.cleanarchitectureplayground.cache;

import com.vginert.cleanarchitectureplayground.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

import io.reactivex.Maybe;

/**
 * @author Vicente Giner Tendero
 */

public class ProductCache implements IProductCache {

    @Override
    public Maybe<List<ProductEntity>> getProducts() {
        // TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public Maybe<List<ProductEntity>> getProductsFromCategory(String categoryId) {
        // TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public Maybe<ProductEntity> getProduct(String id) {
        // TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public void put(ProductEntity product) {
        // TODO implement
        throw new UnsupportedOperationException();
    }

    @Override
    public void put(Collection<ProductEntity> productCollection) {
        // TODO implement
        throw new UnsupportedOperationException();
    }
}
