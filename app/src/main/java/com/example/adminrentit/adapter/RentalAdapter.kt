package com.example.adminrentit.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminrentit.databinding.RentalItemBinding

class RentalAdapter(private val customerNames:ArrayList<String>,private val moneyStatus:ArrayList<String>) : RecyclerView.Adapter<RentalAdapter.RentalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalViewHolder {
        val binding = RentalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RentalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = customerNames.size

    inner class RentalViewHolder(private val binding : RentalItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {

                customerName.text = customerNames[position]
                statusMoney.text=moneyStatus[position]
                val colorMap = mapOf( "received" to Color.GREEN, "not received" to Color.RED, "Pending" to Color.GRAY)
                statusMoney.setTextColor(colorMap[moneyStatus[position]]?:Color.BLACK)
                statusColor.backgroundTintList = ColorStateList.valueOf(colorMap[moneyStatus[position]]?:Color.BLACK)
            }
        }

    }
}