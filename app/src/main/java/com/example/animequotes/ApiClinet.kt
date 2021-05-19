package com.example.animequotes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClinet {
    val Base_Url = "https://animechan.vercel.app/api/"
    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}