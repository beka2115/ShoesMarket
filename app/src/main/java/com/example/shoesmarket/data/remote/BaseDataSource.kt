package com.example.shoesmarket.data.remote

import com.example.shoesmarket.network.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful){
                val body = response.body()
                if (body != null || response.code() in 200 .. 299) return Resource.Success(body)
            }else{
                return  Resource.Error(response.message())
            }
        }catch (e: java.lang.Exception){
            return Resource.Error(e.message ?: e.toString())
        }
        return Resource.Error(call().message())
    }

}

