package com.acel.franchiseapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.acel.franchiseapp.adapter.FranchiseAdapter
import com.acel.franchiseapp.databinding.ActivityHomeBinding
import com.acel.franchiseapp.response.FranchiseResponse
import com.acel.franchiseapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val  list = ArrayList<FranchiseResponse>()
    private lateinit var franchiseadapter: FranchiseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvFranchise.setHasFixedSize(true)
        binding.rvFranchise.layoutManager = LinearLayoutManager(this@HomeActivity)

        ApiService.endpoint.getFranchisors().enqueue(object : Callback<ArrayList<FranchiseResponse>> {

            override fun onResponse(
                call: Call<ArrayList<FranchiseResponse>>,
                response: Response<ArrayList<FranchiseResponse>>
            ) {
                response.body()?.let { list.addAll(it) }
                franchiseadapter = FranchiseAdapter(list, this@HomeActivity)
                binding.rvFranchise.adapter = franchiseadapter
            }

            override fun onFailure(call: Call<ArrayList<FranchiseResponse>>, t: Throwable) {

            }

        })

    }
}