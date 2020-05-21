package com.example.dogbreeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detailed_view.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailedView : AppCompatActivity() {

    val breedName: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        //breedName.add(intent.getStringExtra("Breedname"))
        breedName.add(MainActivity.breedName)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, breedName)
        detailed_breed_view.adapter = adapter
    }
}
