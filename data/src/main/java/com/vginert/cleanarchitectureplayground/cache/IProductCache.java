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
 *         <p>
 *         Interface that represents the product cache
 */

public interface IProductCache {

    /**
     * Get a {@link io.reactivex.Observable} that emit a list of all products
     *
     * @return Observable that emit a list of products
     */
    Maybe<List<ProductEntity>> getProducts();

    /**
     * Get a {@link io.reactivex.Observable} that emit a list of all products from one category
     *
     * @param categoryId The category id for list the products
     * @return Observable that emit a list of products
     */
    Maybe<List<ProductEntity>> getProductsFromCategory(String categoryId);

    /**
     * Get a {@link io.reactivex.Observable} that emit a product from id
     *
     * @param id The id of the product to retrieve the data
     * @return Observable that emit a product
     */
    Maybe<ProductEntity> getProduct(final String id);

    /**
     * Puts a product into the cache.
     *
     * @param product Product to put in the cache.
     */
    void put(ProductEntity product);

    /**
     * Puts a collection of products into the cache.
     *
     * @param productCollection Product collection to put in the cache.
     */
    void put(Collection<ProductEntity> productCollection);
}
