package com.techniquesmyanmar.dropdownlayout.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ProductListAdapter (val list: List<ProductList>) :
    RecyclerView.Adapter<ProductListAdapter.ProductListHolder>() {

        inner class ProductListHolder(private val binding: ProductListItemBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(list : ProductList){
                binding.tvLiveCode.text = list.liveCode
                binding.tvProductName.text = list.productName
                binding.tvProductPrice.text = list.productPrice
                Glide.with(itemView.context)
                    .load(list.productImage)
                    .into(binding.ivProductImage)

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListHolder {
        return ProductListHolder(
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProductListHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}