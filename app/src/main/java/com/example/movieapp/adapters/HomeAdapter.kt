package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movie
import com.example.movieapp.R
import com.example.movieapp.fragments.HomeFragmentDirections

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
        val item = data[position]
        holder.movieTitle.text = item.title
        holder.movieDescription.text = item.description
        holder.seeDetailsBtn.setOnClickListener { v: View -> v.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)) }
    }

}