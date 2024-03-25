package com.example.adminrentit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminrentit.databinding.ItemItemBinding

class AddItemAdapter(private val MenuItemName:ArrayList<String>,
                            private val MenuItemPrice:ArrayList<String>,
                            private val MenuItemImage:ArrayList<Int>) : RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder>() {

    private val itemQuantities = IntArray(MenuItemName.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

        override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount(): Int = MenuItemName.size
        inner class AddItemViewHolder(private val binding: ItemItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int) {

                binding.apply {
                    val quantity = itemQuantities[position]
                    vehicleNameTextView.text = MenuItemName[position]
                    priceTextView.text = MenuItemPrice[position]
                    vehicleImageView.setImageResource(MenuItemImage[position])
                    quantityTextView.text = quantity.toString()
                    minusButton.setOnClickListener {
                        decreaseQuantity(position)
                    }
                    plusBtn.setOnClickListener {
                        increaseQuantity(position)
                    }
                    deleteBtn.setOnClickListener {
                        deleteQuantity(position)
                    }
                }
            }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.quantityTextView.text = itemQuantities[position].toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.quantityTextView.text = itemQuantities[position].toString()
            }
        }

        private fun deleteQuantity(position: Int) {
            MenuItemName.removeAt(position)
            MenuItemPrice.removeAt(position)
            MenuItemImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, MenuItemName.size)
        }
    }
}