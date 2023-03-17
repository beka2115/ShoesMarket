package com.example.shoesmarket.core.network

import android.util.Log
import com.example.shoesmarket.core.network.result.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful){
                val body = response.body()
                if (body != null || response.code() in 200 .. 299) {
                    Log.e("ololo","4")
                    return Resource.Success(body)
                }
            }else{
                Log.e("ololo","3"+response.message())
                return  Resource.Error(response.message())
            }
        }catch (e: java.lang.Exception){
            Log.e("ololo","1"+e.message.toString())
            return Resource.Error(e.message ?: e.toString())
        }
        Log.e("ololo","2"+call().message())
        return Resource.Error(call().message())
    }
}

