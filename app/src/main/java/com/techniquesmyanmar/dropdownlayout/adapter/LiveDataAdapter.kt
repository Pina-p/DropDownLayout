package com.techniquesmyanmar.dropdownlayout.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.techniquesmyanmar.dropdownlayout.activitiy.ViewLiveSellingList
import com.techniquesmyanmar.dropdownlayout.databinding.LiveSaleCardBinding
import com.techniquesmyanmar.dropdownlayout.model.LiveData


class LiveDataAdapter(
    var liveList : ArrayList<LiveData>
):RecyclerView.Adapter<LiveDataAdapter.LiveDataHolder>() {
    inner class LiveDataHolder(private val binding: LiveSaleCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(liveList : LiveData){
            binding.ivLiveSaleImg.load(liveList.img){
                crossfade(1000)
                crossfade(true)
            }
            binding.tvTime.text = liveList.liveTime
            binding.tvCaption.text = liveList.caption
            binding.tvOrderItem.text = liveList.orderItem.toString()
            binding.tvCommentCount.text=liveList.comment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveDataHolder {
        return LiveDataHolder(LiveSaleCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LiveDataHolder, position: Int) {
        holder.bind(liveList[position])
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return liveList.size
    }
}