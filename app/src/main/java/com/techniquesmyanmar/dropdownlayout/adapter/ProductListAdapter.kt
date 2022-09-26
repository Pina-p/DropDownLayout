package com.techniquesmyanmar.dropdownlayout.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.*
import android.widget.*
import androidx.annotation.MenuRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.techniquesmyanmar.dropdownlayout.R
import com.techniquesmyanmar.dropdownlayout.activitiy.FillLiveCodeBottomSheet
import com.techniquesmyanmar.dropdownlayout.databinding.ProductListItemBinding
import com.techniquesmyanmar.dropdownlayout.model.ProductList


class ProductListAdapter (val list: List<ProductList>) :
    RecyclerView.Adapter<ProductListAdapter.ProductListHolder>() {

        inner class ProductListHolder(private val binding: ProductListItemBinding):RecyclerView.ViewHolder(binding.root){

             @RequiresApi(Build.VERSION_CODES.Q)
             fun showMenu(v:View, @MenuRes menuRes: Int,livecode: String,productName:String,price: String,img : Int){
//                 val contextThemeWrapper =
//                     ContextThemeWrapper(itemView.context, R.style.PopupMenuOverlapAnchor)
//                 val popup = PopupMenu(contextThemeWrapper, itemView)
                val popup = PopupMenu(itemView.context!!, v ,Gravity.RIGHT)
                val popupWindow = popupDisplay(livecode,productName,price,img)
                 popupWindow?.showAsDropDown(binding.view)
                 popupWindow?.setOnDismissListener {
                     popupWindow?.dismiss()
                 }
                 //val location = binding.ivMenu.getLocationOnScreen(binding.root.scaleX)
                // popupWindow?.showAtLocation(binding.ivMenu,80,binding.ivMenu.scaleX.toInt(),binding.ivMenu.scaleY.toInt())
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
               // popup.show()
            }
            fun popupDisplay(livecode: String,productName:String,price: String,img: Int): PopupWindow? { // disply designing your popoup window
                val popupWindow = PopupWindow(itemView.context) // inflet your layout or diynamic add view
                val view: View
                val inflater =
                    itemView.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.menu_layout, null)

                var changeLiveCodeLayout = view.findViewById<LinearLayout>(R.id.llLayout1)
                changeLiveCodeLayout.setOnClickListener {
                    popupWindow.dismiss()
                    val manager: FragmentManager =
                        (itemView.context as AppCompatActivity).supportFragmentManager
                    var bottomSheetFragment = FillLiveCodeBottomSheet.newInstance("edit",livecode,productName,price,img)
                    bottomSheetFragment.show(manager,"Note Bottom Sheet Fragment")
                }

                var removeLayout = view.findViewById<LinearLayout>(R.id.llLayout2)
                removeLayout.setOnClickListener{
                    popupWindow.dismiss()
                    var dialogBinding = LayoutInflater.from(itemView.context).inflate(R.layout.confirmation_custom_dialog,null)
                    val myDialog = Dialog(itemView.context)
                    var image = dialogBinding.findViewById<ImageView>(R.id.ivProductImage)
                    var close = dialogBinding.findViewById<ImageView>(R.id.ivClose)
                    var cancel = dialogBinding.findViewById<TextView>(R.id.tvCancel)
                    image.load(img){
                        transformations(RoundedCornersTransformation())
                    }
                    close.setOnClickListener {
                        myDialog.dismiss()
                    }
                    cancel.setOnClickListener {
                        myDialog.dismiss()
                    }
                    myDialog.setContentView(dialogBinding)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()
                }

                popupWindow.isFocusable = true
                popupWindow.width = WindowManager.LayoutParams.WRAP_CONTENT
                popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
                popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                popupWindow.contentView = view
                return popupWindow
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
                    showMenu(binding.ivMenu, R.menu.popup_menu,
                        list.liveCode,list.productName,
                        list.productPrice,list.productImage)
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