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

package com.vginert.cleanarchitectureplayground.repository;

import com.vginert.cleanarchitectureplayground.cache.IProductCache;
import com.vginert.cleanarchitectureplayground.domain.Product;
import com.vginert.cleanarchitectureplayground.domain.repository.IProductRepository;
import com.vginert.cleanarchitectureplayground.entity.mapper.ProductEntityMapper;
import com.vginert.cleanarchitectureplayground.net.ISupermarketApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * @author Vicente Giner Tendero
 */

public class ProductRepository implements IProductRepository {

    private final ISupermarketApi supermarketApi;
    private final IProductCache productCache;
    private final ProductEntityMapper productEntityMapper;

    @Inject
    public ProductRepository(ISupermarketApi supermarketApi, IProductCache productCache, ProductEntityMapper productEntityMapper) {
        this.supermarketApi = supermarketApi;
        this.productCache = productCache;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Observable<List<Product>> getProductsFromCategory(String categoryId) {
        return Maybe.concat(
                // Get product from cache
                productCache.getProductsFromCategory(categoryId),
                // If cache don't return product get it from net and save it to the cache
                this.supermarketApi.getProductsFromCategory(categoryId).toMaybe()
                        .doOnSuccess(this.productCache::put)
        ).toObservable().map(this.productEntityMapper::transform);
    }

    @Override
    public Observable<List<Product>> getProducts() {
        return Maybe.concat(productCache.getProducts(),
                this.supermarketApi.getProducts().toMaybe().doOnSuccess(this.productCache::put))
                .toObservable().map(this.productEntityMapper::transform);
    }

    @Override
    public Observable<Product> getProduct(String id) {
        return Maybe.concat(productCache.getProduct(id),
                this.supermarketApi.getProduct(id).toMaybe().doOnSuccess(this.productCache::put))
                .toObservable().map(this.productEntityMapper::transform);
    }
}
