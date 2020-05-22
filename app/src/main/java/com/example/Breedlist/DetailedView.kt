package com.example.Breedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detailed_view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedView : AppCompatActivity() {

    val breedName: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        breedName.add(MainActivity.breedName)

        val apiService = DogApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val currentBreedResponseItem = apiService.getCurrentBreed(MainActivity.breedName).await()
            textView.text = currentBreedResponseItem.name
            textView.append(currentBreedResponseItem.id.toString())
            textView.append(currentBreedResponseItem.lifeSpan)
            textView.append(currentBreedResponseItem.origin)
            textView.append(currentBreedResponseItem.temperament)
            textView.append(currentBreedResponseItem.weight.metric)
            textView.append(currentBreedResponseItem.height.metric)

        }
        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, breedName)
        //detailed_breed_view.adapter = adapter
    }
}
