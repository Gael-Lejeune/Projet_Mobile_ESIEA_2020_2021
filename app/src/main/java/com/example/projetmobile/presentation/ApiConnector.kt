package com.example.projetmobile.presentation

import com.example.projetmobile.presentation.api.PCApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnector {
    companion object{
        val pcApi: PCApi = Retrofit.Builder()
            .baseUrl("https://api.kuroganehammer.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PCApi::class.java)
    }
}