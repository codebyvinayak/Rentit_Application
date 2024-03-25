package com.example.adminrentit.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminrentit.R
import com.example.adminrentit.adapter.AddItemAdapter
import com.example.adminrentit.databinding.ActivityAllItemBinding


class AllItemActivity : AppCompatActivity() {
    private val binding : ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val menuVehicleName = listOf("Swift Saver ","Mountain Trailblazer","Summit Seeker","Mountain Maverick")
        val menuItemPrice = listOf("600","1800","2000","3000")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu5,
        )
        binding.backButton.setOnClickListener {
            finish()
        }
        val adapter = AddItemAdapter(
            ArrayList(menuVehicleName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage))
        binding.MenuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.MenuRecyclerView.adapter=adapter
    }

}