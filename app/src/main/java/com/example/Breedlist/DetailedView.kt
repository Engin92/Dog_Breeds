package com.example.Breedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detailed_view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)



        val apiService = DogApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val currentBreedResponseItem = apiService.getCurrentBreed(MainActivity.breedName).await()

            for (i in 0 until currentBreedResponseItem.size) {
                if (i == 0) {
                    textView.text = "Name: " + currentBreedResponseItem[i].name + "\n"
                } else {
                    textView.append("Name: " + currentBreedResponseItem[i].name + "\n")
                }
                textView.append("Lifespan: " + currentBreedResponseItem[i].lifeSpan + "\n")
                textView.append("Origin: " + currentBreedResponseItem[i].origin + "\n")
                textView.append("Temperament: " + currentBreedResponseItem[i].temperament + "\n")
                textView.append("Weight: " + currentBreedResponseItem[i].weight.metric + "\n")
                textView.append("Height: " + currentBreedResponseItem[i].height.metric + "\n")
                textView.append("\n")
            }
        }
    }
}
