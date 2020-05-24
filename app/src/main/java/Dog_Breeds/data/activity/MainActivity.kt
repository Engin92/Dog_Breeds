package Dog_Breeds.data.activity

import Dog_Breeds.data.R
import Dog_Breeds.data.view.RoomViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {

    val breedNamesList: ArrayList<String> = ArrayList()

    companion object{
        var breedName: String = String()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read_json()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this,"Cache Deleted!", Toast.LENGTH_LONG).show()
                Thread(Runnable {
                    RoomViewModel.database!!.currentBreedDao().deleteAllBreeds()
                }).start()
        }
    }


    fun read_json()
    {
        val json: String?

        try {
            val inputStream: InputStream = assets.open("breeds.json")
            json = inputStream.bufferedReader().use{it.readText()}

            val jsonObj = JSONObject(json).getJSONObject("message")

            val keys: Iterator<String> = jsonObj.keys()

            while (keys.hasNext()) {
                val key = keys.next()
                breedNamesList.add(key)
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,breedNamesList)
            breed_list_view.adapter = adapter

            breed_list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this@MainActivity,
                    DetailedViewActivity::class.java)
                breedName = breedNamesList[position]
                startActivity(intent)
            }
        }

        catch (e : IOException)
        {

        }
    }
}
