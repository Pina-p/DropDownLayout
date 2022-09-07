package com.techniquesmyanmar.dropdownlayout.activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.techniquesmyanmar.dropdownlayout.adapter.ColorAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityQuickInsertBinding
import com.techniquesmyanmar.dropdownlayout.model.ColorList

class QuickInsert : AppCompatActivity() {
    private lateinit var binding : ActivityQuickInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var unwrappedDrawable = AppCompatResources.getDrawable(this,R.drawable.image_background)
//        var wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
//        DrawableCompat.setTint(wrappedDrawable,Color.GREEN)

        val data : ArrayList<ColorList> = arrayListOf(
            ColorList("#fff066"),
            ColorList("#ff8431"),
            ColorList("#88d2ff"),
            ColorList("#d086e2"),
            ColorList("#b3e583"),

            ColorList("#ffc83e"),
            ColorList("#ff4874"),
            ColorList("#6383ea"),
            ColorList("#bb6ace"),
            ColorList("#82ce32"),

            ColorList("#ff8431"),
            ColorList("#f43d3d"),
            ColorList("#4e72cc"),
            ColorList("#9246a5"),
            ColorList("#68a526")

        )

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.rvColor.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@QuickInsert,5)
            adapter = ColorAdapter(data)
        }

    }

//    private fun setTint(d: Drawable,color: Int) : Drawable{
//        var drawable = DrawableCompat.wrap(d)
//        DrawableCompat.setTint(drawable,color)
//        return drawable
//    }
}