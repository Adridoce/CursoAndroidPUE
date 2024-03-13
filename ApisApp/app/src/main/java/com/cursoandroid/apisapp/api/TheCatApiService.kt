package com.cursoandroid.apisapp.api

import com.cursoandroid.apisapp.models.ImageResultData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApiService {

    @GET("images/search")
    fun searchImages(
        @Query("limit") limit: Int,
        @Query("size") format: String
    ): Call<List<ImageResultData>>
}