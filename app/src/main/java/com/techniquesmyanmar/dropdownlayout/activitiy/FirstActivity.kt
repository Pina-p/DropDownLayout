package com.techniquesmyanmar.dropdownlayout.activitiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.techniquesmyanmar.dropdownlayout.LiveJoinLoading
import com.techniquesmyanmar.dropdownlayout.adapter.LiveDataAdapter
import com.techniquesmyanmar.dropdownlayout.databinding.ActivityFirstBinding
import com.techniquesmyanmar.dropdownlayout.model.LiveData
import kotlin.collections.ArrayList

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    var liveList = ArrayList<LiveData>()
    private lateinit var liveDataAdapter : LiveDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        liveList.add(LiveData("https://blog.ninjavan.co/en-ph/wp-content/uploads/sites/2/2021/11/live-selling-tips.png","5 min ago","Sample Live Caption Here !!",20,"1.2k"))
        liveList.add(LiveData("https://miro.medium.com/max/1200/1*gdxUtYaQyfuC8-jQl4eGdw.jpeg","1 hr ago","Winter is coming!! Promotion is here !!",60,"9.6k"))
        liveList.add(LiveData("https://blog.shopline.my/wp-content/uploads/2021/10/How_Facebook_Live_selling_is_so_much_easier_with_SHOPLINE_LIVE.jpg","6 hr ago","Grab the best offers now!",5,"122"))
        liveList.add(LiveData("https://uploads-ssl.webflow.com/6071145c72cc4375f77ec6fe/61037b9213c18ef1205704ab_Live%20streaming.jpg","12 hr ago","Morning live for New Products !!",30,"3.7k"))

        liveDataAdapter = LiveDataAdapter(liveList)
        binding.rvLiveSale.apply {
            setHasFixedSize(false)
            layoutManager =
                LinearLayoutManager(this@FirstActivity, LinearLayoutManager.VERTICAL, false)
            adapter = liveDataAdapter
        }

        binding.cvJoinLive.setOnClickListener {
            var intent = Intent(this@FirstActivity,LiveJoinLoading::class.java)
            startActivity(intent)
        }

        binding.cvAddProduct.setOnClickListener {
            var intent = Intent(it.context,ViewLiveSellingList::class.java)
            it.context.startActivity(intent)
        }
    }
}