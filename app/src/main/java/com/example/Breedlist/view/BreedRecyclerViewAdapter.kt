package com.example.Breedlist.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Breedlist.R
import com.example.Breedlist.network.response.CurrentBreedResponseItem

class BreedRecyclerViewAdapter (_context : Context, _breedlist:List<CurrentBreedResponseItem>) : RecyclerView.Adapter<BreedRecyclerViewAdapter.BreedViewHolder>() {

    val context = _context
    val breedList = _breedlist

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.breed_layout,parent,false)
        return BreedViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return breedList.size
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breedList[position]
        holder.breedId.text = breed.id.toString()
        holder.breedName.text = breed.name
        holder.breedOrigin.text = breed.origin
        holder.breedBredFor.text = breed.bredFor
        holder.breedLifeSpan.text = breed.lifeSpan
        holder.breedTemperament.text = breed.temperament
        holder.breedHeight.text = breed.height.imperial
        holder.breedWeight.text = breed.weight.metric
    }

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val breedId : TextView = itemView.findViewById(R.id.breed_id)
        val breedName : TextView = itemView.findViewById(R.id.breed_name)
        val breedOrigin : TextView = itemView.findViewById(R.id.breed_origin)
        val breedBredFor : TextView = itemView.findViewById(R.id.breed_bred_for)
        val breedLifeSpan : TextView = itemView.findViewById(R.id.breed_life_span)
        val breedTemperament : TextView = itemView.findViewById(R.id.breed_temperament)
        val breedHeight : TextView = itemView.findViewById(R.id.breed_height)
        val breedWeight : TextView = itemView.findViewById(R.id.breed_weight)
    }
}