package com.example.animequotes

import Json4Kotlin_Base
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("random")
    fun getQuotes():Call<Json4Kotlin_Base>
}