package com.example.adminrentit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminrentit.databinding.ActivityOutForRentalBinding
import com.example.adminrentit.adapter.RentalAdapter

class OutForRentalActivity : AppCompatActivity() {

    private val  binding : ActivityOutForRentalBinding by lazy {
        ActivityOutForRentalBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }
        val customerName = arrayListOf(
            "Ronaldo",
            "John",
            "Alice"
        )

        val moneyStatus = arrayListOf(
            "received",
            "not Received",
            "Pending"
        )

        val adapter = RentalAdapter(customerName,moneyStatus)
        binding.rentalRecyclerView.adapter = adapter
        binding.rentalRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}