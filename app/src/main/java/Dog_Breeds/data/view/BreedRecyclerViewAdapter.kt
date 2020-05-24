package Dog_Breeds.data.view

import Dog_Breeds.data.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Dog_Breeds.data.network.response.CurrentBreedResponseItem

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
        holder.breedId.text = "ID: " + breed.id.toString()
        holder.breedName.text = "Name: " + breed.name
        holder.breedBredFor.text = "Bred for: " + breed.bredFor
        holder.breedLifeSpan.text = "Lifespan: " + breed.lifeSpan
        holder.breedTemperament.text = "Temperament: " + breed.temperament
        holder.breedHeight.text = "Height in cm: " + breed.height.metric
        holder.breedWeight.text = "Weight in cm: " + breed.weight.metric
    }

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val breedId : TextView = itemView.findViewById(R.id.breed_id)
        val breedName : TextView = itemView.findViewById(R.id.breed_name)
        val breedBredFor : TextView = itemView.findViewById(R.id.breed_bred_for)
        val breedLifeSpan : TextView = itemView.findViewById(R.id.breed_life_span)
        val breedTemperament : TextView = itemView.findViewById(R.id.breed_temperament)
        val breedHeight : TextView = itemView.findViewById(R.id.breed_height)
        val breedWeight : TextView = itemView.findViewById(R.id.breed_weight)
    }
}