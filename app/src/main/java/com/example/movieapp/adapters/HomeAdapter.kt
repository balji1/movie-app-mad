package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movie
import com.example.movieapp.R

class HomeAdapter : RecyclerView.Adapter<HomeItemViewHolder>() {

    var data = listOf<Movie>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val inflate = from.inflate(R.layout.fragment_card_item, parent, false)
        return HomeItemViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bindData(data[position])
    }

}