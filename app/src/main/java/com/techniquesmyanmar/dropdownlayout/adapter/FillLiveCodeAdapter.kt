package com.techniquesmyanmar.dropdownlayout.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.databinding.FillLivecodeBottomSheetBinding
import com.techniquesmyanmar.dropdownlayout.databinding.FillLivecodeItemBinding
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList
import com.techniquesmyanmar.dropdownlayout.model.ProductWithLiveCode
import kotlinx.coroutines.flow.merge
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class FillLiveCodeAdapter (var lists: List<ProductList>) :
    RecyclerView.Adapter<FillLiveCodeAdapter.FillLiveCodeHolder>() {

    var emptyLiveCodeList = ArrayList<ProductList>()
    var emptyExcludeList = ArrayList<ProductList>()
    var temp = ArrayList<ProductList>()
    inner class FillLiveCodeHolder(private val binding: FillLivecodeItemBinding):RecyclerView.ViewHolder(binding.root){
        fun checkEmptyLiveCode(){

            for(i in lists){
                if(i.liveCode.isEmpty()){
                  //  Collections.swap(lists,0,lists.indexOf(i))
                    emptyLiveCodeList.add(i)
                }else{
                    emptyExcludeList.add(i)
                }
            }

            temp.addAll(emptyLiveCodeList)
            temp.addAll(emptyExcludeList)

        }


        fun bind(list : ProductList){
            binding.etLivecode.setText(list.liveCode)
            binding.tvProductName.text = list.productName
            binding.tvProductPrice.text = list.productPrice
            Glide.with(itemView.context)
                .load(list.productImage)
                .into(binding.ivProductImage)

            if(list.liveCode.isEmpty()){
                binding.etLivecode.setText(" ")
                //Collections.swap(lists,0,adapterPosition)
                Log.d("List", "bind: $lists")
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FillLiveCodeHolder {
        return FillLiveCodeHolder(
            FillLivecodeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: FillLiveCodeHolder, position: Int) {
        holder.checkEmptyLiveCode()
        Log.d("Temp", "onBindViewHolder: $temp")
        holder.bind(temp[position])
    }

    override fun getItemCount(): Int {
        Log.d("hi", "getItemCount: ${lists.size}")
        return lists.size
    }
}