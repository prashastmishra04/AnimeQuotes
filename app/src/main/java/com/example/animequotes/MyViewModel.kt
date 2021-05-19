package com.example.animequotes

import Json4Kotlin_Base
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyViewModel() : ViewModel() {
    private var QuoteList: MutableLiveData<Json4Kotlin_Base>? = null

    fun getQuotes(): MutableLiveData<Json4Kotlin_Base>? {
        //if the list is null
            QuoteList = MutableLiveData<Json4Kotlin_Base>()
            //we will load it asynchronously from server in this method
            load()
        //finally we will return the list
        return QuoteList
    }

    public  fun load() {
        ApiClinet().getApiClient()?.create(ApiInterface::class.java).also { it ->
            if (it != null) {
                it.getQuotes().enqueue(object : retrofit2.Callback<Json4Kotlin_Base> {
                    override fun onResponse(
                        call: Call<Json4Kotlin_Base>,
                        response: Response<Json4Kotlin_Base>
                    ) {
                        if (response.isSuccessful) {
                            Log.i("success", "working")

                            QuoteList?.setValue(response.body());
                        } else {
                            Log.i("unsucess", "not working")
                        }
                    }
                    override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                        Log.i("error", "error")
                    }
                })
            }
        }
    }
    }







