package com.ami.mvvmexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    //https://api.nationalize.io/?name=nathaniel
    private const val BASE_URL="https://api.nationalize.io/"
    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}