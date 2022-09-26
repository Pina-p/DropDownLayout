package com.techniquesmyanmar.dropdownlayout.activitiy

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.adapter.FillLiveCodeAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityLiveJoinLoadingBinding
import com.techniquesmyanmar.dropdownlayout.databinding.FillLivecodeBottomSheetBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class FillLiveCodeBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding : FillLivecodeBottomSheetBinding
    companion object{
        var editOrFill = ""
        var live_code = ""
        var product_name = ""
        var p = ""
        var image = 0
        fun newInstance(editFill: String,liveCode :String,productName: String,price: String,img: Int): FillLiveCodeBottomSheet{
            var args = Bundle()
            val fragment =FillLiveCodeBottomSheet()
            fragment.arguments = args
            editOrFill =  editFill
            live_code = liveCode
            product_name = productName
            p = price
            image = img
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FillLivecodeBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getTheme() = R.style.NoBackgroundDialogTheme
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: MutableList<ProductList> = mutableListOf(
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Orange fruit","","150,000 Ks"),
            ProductList(R.drawable.product_image,"CC fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"BB fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.product_image,"Example fruit","","150,000 Ks"),
            ProductList(R.drawable.product_image,"Purple fruit","AH86","150,000 Ks"),
            )


        binding.ivClose.setOnClickListener {
            dialog?.dismiss()
        }
        binding.rvFillLiveCode.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = FillLiveCodeAdapter(data)
        }

        if(editOrFill == "edit"){
            binding.tvInsertLiveCode.text = "Edit Live Code"
            binding.btnSave.text = "Save"
            binding.btnSave.layoutParams.width = 140
            //binding.btnSave.layoutParams = ConstraintLayout.LayoutParams(70,60)
            binding.rvFillLiveCode.setPadding(0,0,0,30)
            binding.tvNoLiveCode.visibility = View.GONE
            val data : MutableList<ProductList>  = mutableListOf(
                ProductList(image, product_name, live_code,p)
            )
            binding.rvFillLiveCode.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(view.context)
                adapter = FillLiveCodeAdapter(data)
            }

        }else if(editOrFill == "fill"){
            binding.tvNoLiveCode.visibility = View.VISIBLE
        }

    }
}