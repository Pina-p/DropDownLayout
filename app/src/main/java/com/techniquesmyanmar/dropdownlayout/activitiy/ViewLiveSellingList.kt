package com.techniquesmyanmar.dropdownlayout.activitiy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.adapter.ProductListAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityViewLivesaleBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ViewLiveSellingList : AppCompatActivity() {
    private lateinit var binding: ActivityViewLivesaleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewLivesaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var unwrappedDrawable = AppCompatResources.getDrawable(this,R.drawable.border_et)
//          var wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
//          DrawableCompat.setTint(wrappedDrawable, Color.GREEN)

        val data: ArrayList<ProductList> = arrayListOf(
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),


        )

        binding.rvProductList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ViewLiveSellingList)
            adapter = ProductListAdapter(data)
        }

        binding.btnChoose.setOnClickListener {
            Intent(this, SelectFromProductList::class.java).also {
                startActivity(it)
            }
        }

        binding.btnQuickAdd.setOnClickListener {
            Intent(this, QuickInsert::class.java).also {
                startActivity(it)
            }
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.etSearch.setBackgroundResource(R.drawable.search_border)
    }
}