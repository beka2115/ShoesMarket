package com.example.shoesmarket.data.remote

import com.example.shoesmarket.data.remote.model.ProductDetailList
import com.example.shoesmarket.core.network.BaseDataSource
import com.example.shoesmarket.core.network.result.Resource
import com.example.shoesmarket.core.network.RetrofitClient

class RemoteDataSource() : BaseDataSource() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    suspend fun getProductDetailList(id: Int): Resource<ProductDetailList> {
        return getResult {
            apiService.getProductDetailList(id)
        }
    }
}