package com.techniquesmyanmar.dropdownlayout.adapter

import android.graphics.Color
import android.os.Build
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList

class ProductListAdapter (val list: List<ProductList>) :
    RecyclerView.Adapter<ProductListAdapter.ProductListHolder>() {

        inner class ProductListHolder(private val binding: ProductListItemBinding):RecyclerView.ViewHolder(binding.root){

             @RequiresApi(Build.VERSION_CODES.Q)
             fun showMenu(v:View, @MenuRes menuRes: Int){
                val popup = PopupMenu(itemView.context!!, v ,Gravity.LEFT)
                popup.menuInflater.inflate(menuRes, popup.menu)
                popup.setForceShowIcon(true)
                popup.setOnDismissListener {
                    // Respond to popup being dismissed.
                    popup.dismiss()
                }
                 popup.setOnMenuItemClickListener { item ->
                     when (item.itemId) {
                         R.id.option_remove ->
                             Hello()

                         R.id.option_changeLiveCode ->                         //handle menu2 click
                             true
                         else -> false
                     }
                 }
                 // Show the popup menu.
                popup.show()
            }
            fun Hello(): Boolean {
                Toast.makeText(itemView.context, "Menu", Toast.LENGTH_SHORT).show()
                return true
            }
            @RequiresApi(Build.VERSION_CODES.Q)
            fun bind(list : ProductList){

                binding.tvLiveCode.text = list.liveCode
                binding.tvProductName.text = list.productName
                binding.tvProductPrice.text = list.productPrice
                if(list.liveCode == ""){
                    binding.tvLiveCode.text = "Live Code မရှိပါ"
                    binding.tvLiveCode.setTextColor(Color.GRAY)
                }
                binding.ivProductImage.load(list.productImage){
                    transformations(RoundedCornersTransformation())
                }
                binding.ivMenu.setOnClickListener {
                    if(binding.cardMenu.isVisible == true){
                        binding.cardMenu.visibility = View.GONE
                    }else{
                        binding.cardMenu.visibility = View.VISIBLE
                    }

//                    showMenu(binding.ivMenu, R.menu.popup_menu)
                }


            }
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListHolder {
        return ProductListHolder(
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: ProductListHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}