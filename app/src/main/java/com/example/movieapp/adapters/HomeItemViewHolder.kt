package com.example.movieapp.adapters

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movie
import com.example.movieapp.R
import com.example.movieapp.fragments.HomeFragmentDirections

class HomeItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val movieTitle: TextView = itemView.findViewById(R.id.card_item_title)
    private val movieDescription: TextView = itemView.findViewById(R.id.card_item_story)
    private val seeDetailsBtn: Button = itemView.findViewById(R.id.card_item_seeDetails)

    //Binds data to each item in the Recycler view
    fun bindData(item: Movie){
        this.movieTitle.text = item.title
        this.movieDescription.text = item.description
        this.seeDetailsBtn.setOnClickListener { v: View -> v.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)) }
    }
}
