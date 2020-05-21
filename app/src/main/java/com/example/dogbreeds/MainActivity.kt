package com.example.dogbreeds

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    val breedNames: ArrayList<String> = ArrayList()

    companion object{
        var breedName: String = String()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read_json()
    }

    fun read_json()
    {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open("breeds.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonObj = JSONObject(json).getJSONObject("message")

            val keys: Iterator<String> = jsonObj.keys()

            while (keys.hasNext()) {
                val key = keys.next()
                breedNames.add(key)

                var jsonArray = jsonObj.getJSONArray(key)

                if (jsonArray.length() > 0 ){
                    println("Subbreed" + jsonObj.getJSONArray(key))
                }

            }

            var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,breedNames)
            breed_list_view.adapter = adapter

            breed_list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

                //Toast.makeText(applicationContext, "SubBreeds"  , Toast.LENGTH_LONG).show()

                val intent = Intent(this@MainActivity,DetailedView::class.java)
                breedName = breedNames[position]
                startActivity(intent)
            }
        }

        catch (e : IOException)
        {

        }
    }
}