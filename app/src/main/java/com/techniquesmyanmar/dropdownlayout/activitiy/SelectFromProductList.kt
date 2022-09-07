package com.techniquesmyanmar.dropdownlayout.activitiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.adapter.ChooseProductListAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivitySelectFromProductListBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class SelectFromProductList : AppCompatActivity() {
    private lateinit var binding: ActivitySelectFromProductListBinding
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectFromProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        if(binding.chipAll.isChecked){
//            Log.d("Chip", "onCreate: ${binding.chipAll.isSelected}")
//            binding.chipAll.setTextColor(Color.parseColor("#ffffff"))
//        }
//
//        Log.d("Checked", "onCreate: $binding.cgCategory.checkedChipId")

        val data: ArrayList<ProductList> = arrayListOf(
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),

            )
        binding.cbChooseAll.setOnClickListener {
            check = binding.cbChooseAll.isChecked
            binding.rvCheckboxProductList.adapter = ChooseProductListAdapter(data,check)

        }

        binding.tvChooseAll.setOnClickListener {
            binding.cbChooseAll.isChecked = !binding.cbChooseAll.isChecked
            check = binding.cbChooseAll.isChecked
            binding.rvCheckboxProductList.adapter = ChooseProductListAdapter(data,check)
            //Log.d("Check", "onCreate: $check")
        }

        binding.rvCheckboxProductList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectFromProductList)
            adapter = ChooseProductListAdapter(data,check)
            Log.d("Check", "onCreate: $check")
        }

        binding.btnContinue.setOnClickListener {
            var noteBottomSheetFragment = FillLiveCodeBottomSheet()
            noteBottomSheetFragment.show(supportFragmentManager,"Note Bottom Sheet Fragment")
        }



    }
}