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

package com.vginert.cleanarchitectureplayground.net;

import com.vginert.cleanarchitectureplayground.entity.CategoryEntity;
import com.vginert.cleanarchitectureplayground.entity.ProductEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Vicente Giner Tendero
 */

public interface ISupermarketApi {

    String BASE_URL = "https://github.com/vginert/sample-data/blob/master/product_sample_data/";

    @GET("products.json")
    Observable<List<ProductEntity>> getProducts();

    @GET("categories/{category_id}.json")
    Observable<List<ProductEntity>> getProductsFromCategory(@Path("category_id") String categoryId);

    @GET("products/{id}.json")
    Observable<ProductEntity> getProduct(@Path("id") String id);

    @GET("categories.json")
    Observable<List<CategoryEntity>> getCategories();
}
