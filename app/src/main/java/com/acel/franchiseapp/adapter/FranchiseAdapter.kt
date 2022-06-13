package com.acel.franchiseapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acel.franchiseapp.R
import com.acel.franchiseapp.detail.DetailActivity
import com.acel.franchiseapp.response.FranchiseResponse
import com.bumptech.glide.Glide

class FranchiseAdapter (private val list: ArrayList<FranchiseResponse>, private val context: Context): RecyclerView.Adapter<FranchiseAdapter.FranchiseViewHolder>() {

    inner class FranchiseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(franchiseResponse: FranchiseResponse) {

            with(itemView) {
                val imageFranchise = franchiseResponse.logo
                val textCost = "${franchiseResponse.investment_cost}"
                val textName = franchiseResponse.nama_usaha
                val tanggal = franchiseResponse.tanggal_berdiri
                val location = franchiseResponse.lokasi

                val tvCost = findViewById<TextView>(R.id.franchisor_cost)
                    tvCost.text = textCost
                val tvName = findViewById<TextView>(R.id.franchisename_txt)
                    tvName.text = textName
                val tvTanggal = findViewById<TextView>(R.id.tanggal_txt)
                    tvTanggal.text = tanggal
                val tvLoc = findViewById<TextView>(R.id.locationfranchise)
                    tvLoc.text = location

                val imgFranchise = findViewById<ImageView>(R.id.image_franchisors)

                Glide.with(itemView)
                    .load(imageFranchise)
                    .into(imgFranchise)

                itemView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("data", franchiseResponse)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FranchiseViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return FranchiseViewHolder(view)
    }

    override fun onBindViewHolder(holder: FranchiseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}