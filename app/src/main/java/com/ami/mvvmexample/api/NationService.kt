package com.ami.mvvmexample.api

import com.ami.mvvmexample.models.Nationalize
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NationService {
    @GET("/")
    suspend fun getNations(@Query("name") name: String): Response<Nationalize>
}