package com.example.projetmobile.presentation

import com.example.projetmobile.presentation.PCApp.Companion.context
import com.example.projetmobile.presentation.api.PCApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class ApiConnector {
    companion object{
        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024) //10MB
        val okHttpClient: OkHttpClient = OkHttpClient()
            .newBuilder()
            .cache(cache)
            .build()

        val pcApi: PCApi = Retrofit.Builder()
            .baseUrl("https://api.kuroganehammer.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PCApi::class.java)
    }
}