package com.acel.franchiseapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acel.franchiseapp.databinding.ActivityDetailBinding
import com.acel.franchiseapp.response.FranchiseResponse
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private lateinit var franchiseResponse: FranchiseResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        franchiseResponse = intent.getParcelableExtra<FranchiseResponse>("data")!!
        supportActionBar!!.title = franchiseResponse.nama_usaha
        Glide.with(this)
            .load(franchiseResponse.logo)
            .into(binding.imgAvatar)

        binding.franchisorsCost.text = franchiseResponse.investment_cost
        binding.franchisorsnameTxt.text = franchiseResponse.nama_usaha
        binding.txtags.text = franchiseResponse.tags
        binding.franchiseDescription.text = franchiseResponse.deskripsi_usaha
        binding.kontaktxt.text = franchiseResponse.kontak
        binding.emailtxt.text = franchiseResponse.email
        binding.locfranchise.text = franchiseResponse.lokasi

        }
    }
