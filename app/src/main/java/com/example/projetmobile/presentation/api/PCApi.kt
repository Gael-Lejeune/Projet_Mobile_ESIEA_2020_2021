package com.example.projetmobile.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface PCApi {
    @GET("pokemon")
    fun getPCList(): Call<PCResponse>
}