package com.techniquesmyanmar.dropdownlayout.adapter

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.databinding.ColorListItemBinding
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ColorList
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ColorAdapter (val list: List<ColorList>) :
    RecyclerView.Adapter<ColorAdapter.ColorHolder>() {

    inner class ColorHolder(private val binding: ColorListItemBinding):RecyclerView.ViewHolder(binding.root){

        @SuppressLint("ResourceAsColor")
        fun bind(list : ColorList){
            binding.CardView.setCardBackgroundColor(Color.parseColor(list.color))
           // binding.ivColor.setBackgroundColor(android.R.color.transparent)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        return ColorHolder(
            ColorListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}