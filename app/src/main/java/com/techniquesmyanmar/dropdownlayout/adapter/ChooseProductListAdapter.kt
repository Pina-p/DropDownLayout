package com.techniquesmyanmar.dropdownlayout.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.databinding.ChooseProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ChooseProductListAdapter (val list: List<ProductList>,check:Boolean) :
    RecyclerView.Adapter<ChooseProductListAdapter.ChooseProductHolder>() {
    var selected = -1
    var checked = check

    inner class ChooseProductHolder(private val binding: ChooseProductListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : ProductList){
            binding.tvLiveCode.text = list.liveCode
            binding.tvProductName.text = list.productName
            binding.tvProductPrice.text = list.productPrice
            binding.ivImage.load(list.productImage){
                transformations(RoundedCornersTransformation())
            }

            binding.cbChooseAll.setOnClickListener {
                if(binding.cbChooseAll.isChecked == true){
                    selected = 1
                }
                sendCheckedDataToActivity(itemView.context)
            }

            if(list.liveCode == ""){
                binding.tvLiveCode.text = "Live Code မရှိပါ"
                binding.tvLiveCode.setTextColor(Color.GRAY)
            }

            if(checked == true){
                binding.cbChooseAll.isChecked = true
                selected = 1

            }else{
                selected = 0
            }



            binding.root.setOnClickListener {
                binding.cbChooseAll.isChecked = !binding.cbChooseAll.isChecked
                if(binding.cbChooseAll.isChecked == true){
                    selected = 1
                }
                sendCheckedDataToActivity(itemView.context)
            }
            sendCheckedDataToActivity(itemView.context)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseProductHolder {
        return ChooseProductHolder(
            ChooseProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ChooseProductHolder, position: Int) {
        holder.bind(list[position])
        var checkbox = holder.itemView.findViewById<CheckBox>(R.id.cbChooseAll)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun sendCheckedDataToActivity(context: Context){
        var intent = Intent("btn_control")
        intent.putExtra("isChecked",selected)
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
    }
}