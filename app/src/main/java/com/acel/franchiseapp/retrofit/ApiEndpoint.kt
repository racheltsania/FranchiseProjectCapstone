package com.acel.franchiseapp.retrofit

import com.acel.franchiseapp.response.FranchiseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("/franchisors")
    fun getFranchisors():Call<ArrayList<FranchiseResponse>>
}