package com.techniquesmyanmar.dropdownlayout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.techniquesmyanmar.dropdownlayout.databinding.CommentCardBinding

import com.techniquesmyanmar.dropdownlayout.model.CommentData

class LiveCommentAdapter(
    var commentList : ArrayList<CommentData>
): RecyclerView.Adapter<LiveCommentAdapter.CommentDataHolder>() {
    inner class CommentDataHolder(private val binding: CommentCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(commentList: CommentData){
            binding.ivImage.load(commentList.img){
                crossfade(1000)
                crossfade(true)
            }
            binding.tvBuyerName.text=commentList.name
            binding.tvCommentTime.text=commentList.time
            binding.tvComment.text=commentList.comment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentDataHolder {
       return CommentDataHolder(CommentCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CommentDataHolder, position: Int) {
        holder.bind(commentList[position])
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}