package com.techniquesmyanmar.dropdownlayout.activitiy

import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityMainBinding
import com.techniquesmyanmar.dropdownlayout.databinding.FillLivecodeItemBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}