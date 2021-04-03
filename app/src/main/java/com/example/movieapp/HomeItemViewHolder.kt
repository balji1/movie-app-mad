package com.example.movieapp

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val movieTitle: TextView = itemView.findViewById(R.id.card_item_title)
    val seeDetailsBtn: Button = itemView.findViewById(R.id.card_item_seeDetails)
    //actor
    //descrpt
}
