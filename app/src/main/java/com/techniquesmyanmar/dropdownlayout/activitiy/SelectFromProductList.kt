package com.techniquesmyanmar.dropdownlayout.activitiy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.localbroadcastmanager.content.LocalBroadcastManager
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
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.naruto_profile,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.naruto_profile,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.naruto_profile,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.naruto_profile,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.naruto_profile,"Purple fruit","AH86","150,000 Ks"),

            )



        binding.cbChooseAll.setOnClickListener {
            check = binding.cbChooseAll.isChecked
            if(binding.cbChooseAll.isChecked == true){
                binding.btnContinue.visibility = View.VISIBLE
            }else{
                binding.btnContinue.visibility = View.INVISIBLE
            }
            binding.rvCheckboxProductList.adapter = ChooseProductListAdapter(data,check)

        }

        binding.cgCategory.isSelectionRequired = true
        binding.tvChooseAll.setOnClickListener {
            binding.cbChooseAll.isChecked = !binding.cbChooseAll.isChecked
            check = binding.cbChooseAll.isChecked
            binding.rvCheckboxProductList.adapter = ChooseProductListAdapter(data,check)
            //Log.d("Check", "onCreate: $check")
        }


        LocalBroadcastManager.getInstance(this@SelectFromProductList).registerReceiver(
            BroadcastReceiver, IntentFilter("btn_control")
        )

        binding.etSearch.doAfterTextChanged {

        }
        binding.etSearch.setBackgroundResource(R.drawable.search_border)
        binding.rvCheckboxProductList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectFromProductList)
            adapter = ChooseProductListAdapter(data,check)

            Log.d("Check", "onCreate: $check")
        }

        binding.btnContinue.setOnClickListener {
            var bottomSheetFragment = FillLiveCodeBottomSheet()
           bottomSheetFragment.show(supportFragmentManager,"Note Bottom Sheet Fragment")
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.etSearch.doAfterTextChanged {
            binding.ivSearchOrClose.setImageDrawable(resources.getDrawable(R.drawable.ic_search_close))
            binding.ivSearchOrClose.setOnClickListener {
                binding.etSearch.setText("")
                binding.ivSearchOrClose.setImageResource(R.drawable.ic_search)
            }
        }
    }
    private val BroadcastReceiver : BroadcastReceiver = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var isChecked = p1?.getIntExtra("isChecked",-1)
            if(isChecked == 1){
                binding.btnContinue.visibility = View.VISIBLE
            }else{
                binding.btnContinue.visibility = View.INVISIBLE
            }
        }
    }
}