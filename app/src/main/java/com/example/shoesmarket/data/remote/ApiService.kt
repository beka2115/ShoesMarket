package com.example.shoesmarket.data.remote

import com.example.shoesmarket.data.remote.model.ProductDetailList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("products/{id}/")
    suspend fun getProductDetailList(
        @Path("id") id: Int
    ): Response<ProductDetailList>

}
