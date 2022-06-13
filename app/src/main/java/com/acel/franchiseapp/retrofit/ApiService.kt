package com.acel.franchiseapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL : String = "https://waralobby-project.et.r.appspot.com/franchisors/"
    val endpoint : ApiEndpoint
    get() {
        val retrofit = Retrofit.Builder()
            .baseUrl( BASE_URL )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create( ApiEndpoint::class.java)
    }
}