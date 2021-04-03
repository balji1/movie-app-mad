package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter : RecyclerView.Adapter<HomeItemViewHolder>() {

    var data = listOf<Movie>()
        set(value){
            field = value
            notifyDataSetChanged() //re render set data
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
        holder.seeDetailsBtn.setOnClickListener { v: View -> v.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)) } //navigates too
    }

}