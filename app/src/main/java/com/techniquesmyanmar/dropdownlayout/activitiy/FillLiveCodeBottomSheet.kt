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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: MutableList<ProductList> = mutableListOf(
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Orange fruit","","150,000 Ks"),
            ProductList(R.drawable.image_background,"CC fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"BB fruit","AH86","150,000 Ks"),
            ProductList(R.drawable.image_background,"Example fruit","","150,000 Ks"),
            ProductList(R.drawable.image_background,"Purple fruit","AH86","150,000 Ks"),
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

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fill_livecode_bottom_sheet,null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    TODO("Not yet implemented")
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when (newState) {
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "COLLAPSED"
                        }

                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }

                    }
                }

            })


        }
    }
}