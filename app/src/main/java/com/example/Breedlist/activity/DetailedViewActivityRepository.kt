package com.example.Breedlist.activity

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.Breedlist.view.RoomViewModel
import com.example.Breedlist.network.response.CurrentBreedResponseItem
import com.example.Breedlist.retrofit.RestApi
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailedViewActivityRepository{

    val BASE_URL = "https://api.thedogapi.com/v1/breeds/"
    val TAG = DetailedViewActivityRepository::class.java.simpleName


    fun getBreeds() : LiveData<List<CurrentBreedResponseItem>>
    {
        return RoomViewModel.database!!.currentBreedDao().getAllBreeds()
    }

    fun ApiCallAndPutInDB()
    {
        val gson = Gson()
        val retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllBreeds(MainActivity.breedName).enqueue(object : Callback<List<CurrentBreedResponseItem>> {

            override fun onFailure(call: Call<List<CurrentBreedResponseItem>>?, t: Throwable?) {
                Log.e(TAG,"OOPS!! something went wrong..")
            }

            override fun onResponse(call: Call<List<CurrentBreedResponseItem>>?, response: Response<List<CurrentBreedResponseItem>>?) {

                Log.e(TAG,response!!.body().toString())
                when(response.code())
                {
                    200 ->{
                        Thread(Runnable {
                            RoomViewModel.database!!.currentBreedDao().deleteAllBreeds()
                            RoomViewModel.database!!.currentBreedDao().insertAllBreeds(response.body()!!)
                        }).start()
                    }
                }
            }
        })
    }
}