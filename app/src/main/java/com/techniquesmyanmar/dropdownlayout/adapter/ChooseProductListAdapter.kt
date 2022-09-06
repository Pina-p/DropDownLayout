package com.techniquesmyanmar.dropdownlayout.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.techniquesmyanmar.dropdownlayout.databinding.ChooseProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ChooseProductListAdapter (val list: List<ProductList>) :
    RecyclerView.Adapter<ChooseProductListAdapter.ChooseProductHolder>() {

    inner class ChooseProductHolder(private val binding: ChooseProductListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : ProductList){
            binding.tvProductModel.text = list.productModel
            binding.tvProductName.text = list.productName
            binding.tvProductPrice.text = list.productPrice
            Glide.with(itemView.context)
                .load(list.productImage)
                .into(binding.ivImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseProductHolder {
        return ChooseProductHolder(
            ChooseProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ChooseProductHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}