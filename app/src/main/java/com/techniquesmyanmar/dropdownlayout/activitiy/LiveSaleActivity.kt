package com.techniquesmyanmar.dropdownlayout.activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.techniquesmyanmar.dropdownlayout.adapter.LiveCommentAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityLiveSaleBinding
import com.techniquesmyanmar.dropdownlayout.model.CommentData

class LiveSaleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLiveSaleBinding
    var commentList = ArrayList<CommentData>()
    private lateinit var liveCommentAdapter: LiveCommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_live_sale)
        binding= ActivityLiveSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        commentList.add(CommentData("https://thumbs.dreamstime.com/b/passport-photo-african-american-mature-adult-woman-passport-photo-african-american-mature-adult-woman-isolated-white-168920621.jpg","Mrs. Denny Rean","5 min","VS78"))
        commentList.add(CommentData("https://thumbs.dreamstime.com/b/passport-photo-african-american-mature-adult-woman-passport-photo-african-american-mature-adult-woman-isolated-white-168920621.jpg","Mrs. Aris","4 min","When will the giveaway start??"))
        commentList.add(CommentData("https://thumbs.dreamstime.com/b/passport-photo-african-american-mature-adult-woman-passport-photo-african-american-mature-adult-woman-isolated-white-168920621.jpg","Mrs. Denny Rean","2 min","CS65"))
        commentList.add(CommentData("https://thumbs.dreamstime.com/b/passport-photo-african-american-mature-adult-woman-passport-photo-african-american-mature-adult-woman-isolated-white-168920621.jpg","Mrs. Denny Rean","2 min","Can I replace my order with another product?"))
        commentList.add(CommentData("https://thumbs.dreamstime.com/b/passport-photo-african-american-mature-adult-woman-passport-photo-african-american-mature-adult-woman-isolated-white-168920621.jpg","Mrs. Denny Rean","1 min","NR45=2"))

        liveCommentAdapter= LiveCommentAdapter(commentList)
        binding.rvComment.apply {
            setHasFixedSize(false)
            adapter=liveCommentAdapter
        }

    }
}