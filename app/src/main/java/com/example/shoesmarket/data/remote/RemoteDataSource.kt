package com.example.shoesmarket.data.remote

import com.example.shoesmarket.data.remote.model.ProductDetailList
import com.example.shoesmarket.network.Resource
import com.example.shoesmarket.network.RetrofitClient
import kotlinx.coroutines.flow.Flow

class RemoteDataSource() : BaseDataSource() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    suspend fun getProductDetailList(id: Int):Resource<ProductDetailList> {
        return getResult {
            apiService.getProductDetailList(id)
        }
    }

}