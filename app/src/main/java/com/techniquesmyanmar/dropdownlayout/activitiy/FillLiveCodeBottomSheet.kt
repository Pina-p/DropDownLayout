package com.techniquesmyanmar.dropdownlayout.activitiy

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.adapter.FillLiveCodeAdapter
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class FillLiveCodeBottomSheet : BottomSheetDialogFragment() {

//    companion object{
//        fun newInstance(id: Int): FillLiveCodeBottomSheet{
//            var args = Bundle()
//            val fragment =FillLiveCodeBottomSheet()
//            fragment.arguments = args
//            return fragment
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fill_livecode_bottom_sheet, container, false)
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
        var rvFillLiveCode = view.findViewById<RecyclerView>(R.id.rvFillLiveCode)
        var ivClose = view.findViewById<ImageView>(R.id.ivClose)
        ivClose.setOnClickListener {
            dialog?.dismiss()
        }
        rvFillLiveCode.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = FillLiveCodeAdapter(data)
        }

    }
}