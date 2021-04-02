package com.example.projetmobile.presentation.api

import com.example.projetmobile.presentation.list.PC
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PCApi {
    @GET("characters")
    fun getPCList(): Call<List<PC>>

    @GET("characters/name/{name}")
    fun getPCDetails(@Path("name") name: String): Call<PC>
}