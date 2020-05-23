package com.example.Breedlist.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Breedlist.view.BreedRecyclerViewAdapter
import com.example.Breedlist.R
import com.example.Breedlist.network.response.CurrentBreedResponseItem

class DetailedViewActivity : AppCompatActivity() {

    lateinit var breedRecyclerView: RecyclerView
    lateinit var detailedViewActivityViewModel: DetailedViewActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        breedRecyclerView = findViewById(R.id.breedRecyclerView)

        detailedViewActivityViewModel = ViewModelProviders.of(this).get(
            DetailedViewActivityViewModel::class.java)


        if(isOnline(this))
        {
            detailedViewActivityViewModel.getBreedsFromAPIAndStore()
        }
        else
        {
            Toast.makeText(this,"No internet connection. Showing cached list!",Toast.LENGTH_LONG).show()
        }

        detailedViewActivityViewModel.getAllBreedList().observe(this, Observer<List<CurrentBreedResponseItem>> { breedList ->
            Log.e(MainActivity::class.java.simpleName,breedList.toString())
            setUpBreedRecyclerView(breedList!!)
        })
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

    fun setUpBreedRecyclerView(breeds : List<CurrentBreedResponseItem>)
    {
        val breedRecyclerViewAdapter =
            BreedRecyclerViewAdapter(this, breeds)
        breedRecyclerView.adapter = breedRecyclerViewAdapter
        breedRecyclerView.layoutManager = GridLayoutManager(this,2)
        breedRecyclerView.setHasFixedSize(true)
    }
}