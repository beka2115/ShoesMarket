package com.example.shoesmarket.repository

import com.example.shoesmarket.data.remote.RemoteDataSource
import com.example.shoesmarket.data.remote.model.ProductDetailList
import com.example.shoesmarket.core.network.result.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class Repository(){

    private val dataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }
    fun getProductDetailList(id: Int): Flow<Resource<ProductDetailList>> = flow {
        emit(Resource.Loading())
        val response = dataSource.getProductDetailList(id)
        emit(response)
    }.flowOn(Dispatchers.IO)

}