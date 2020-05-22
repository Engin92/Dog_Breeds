package com.example.Breedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.Breedlist.network.BreedNetworkDataSource
import com.example.Breedlist.network.BreedNetworkDataSourceImpl
import com.example.Breedlist.network.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_detailed_view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailedView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val apiService = DogApiService(ConnectivityInterceptorImpl(this.applicationContext!!))
        val BreedNetworkDataSource = BreedNetworkDataSourceImpl(apiService)

        BreedNetworkDataSource.downloadedCurrentBreed.observe(this, Observer {
            for (i in 0 until it.size) {
                if (i == 0) {
                    textView.text = "Name: " + it[i].name + "\n"
                } else {
                    textView.append("Name: " + it[i].name + "\n")
                }
                textView.append("Lifespan: " + it[i].lifeSpan + "\n")
                textView.append("Origin: " + it[i].origin + "\n")
                textView.append("Temperament: " + it[i].temperament + "\n")
                textView.append("Weight: " + it[i].weight.metric + "\n")
                textView.append("Height: " + it[i].height.metric + "\n")
                textView.append("\n")
            }
        }
        )

        GlobalScope.launch(Dispatchers.Main) {
            BreedNetworkDataSource.fetchCurrentBreed(MainActivity.breedName)
        }
    }
}
