package com.acel.franchiseapp.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FranchiseResponse(

    @field:SerializedName("id_franchisor")
    val id_franchisor: Int,

    @field:SerializedName("nama_usaha")
    val nama_usaha: String? = null,

    @field:SerializedName("tags")
    val tags: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("tanggal_berdiri")
    val tanggal_berdiri: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("kontak")
    val kontak: String? = null,

    @field:SerializedName("deskripsi_usaha")
    val deskripsi_usaha: String? = null,

    @field:SerializedName("investment_cost")
    val investment_cost: String,

    @field:SerializedName("lokasi")
    val lokasi: String? = null
): Parcelable