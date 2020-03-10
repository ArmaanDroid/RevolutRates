package com.armaan.revolutrates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView

class CurrenciesAdapter : RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageViewFlag = itemView.findViewById<SimpleDraweeView>(R.id.imageViewFlag)
        val editTextAmount = itemView.findViewById<EditText>(R.id.editTextAmount)
        val tvCurrencyCode = itemView.findViewById<TextView>(R.id.tvCurrencyCode)
        val tvCurrncyName = itemView.findViewById<TextView>(R.id.tvCurrncyName)

        fun setData(position: Int) {
            imageViewFlag.setActualImageResource(R.drawable.splash_screen)
        }

        // Comapnion object for instantiating the viewholder in more convienient way
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_currencies, parent, false)

                return ViewHolder(view)
            }
        }
    }

}