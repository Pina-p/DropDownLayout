package com.techniquesmyanmar.dropdownlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.techniquesmyanmar.dropdownlayout.activitiy.LiveSaleActivity
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityLiveJoinLoadingBinding
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityLiveSaleBinding

class LiveJoinLoading : AppCompatActivity() {
    private lateinit var binding : ActivityLiveJoinLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveJoinLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this,LiveSaleActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}