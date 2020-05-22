package com.example.Breedlist.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.Breedlist.DogApiService
import com.example.Breedlist.internal.NoConnectivityException
import com.example.Breedlist.network.response.CurrentBreedResponseItem

class BreedNetworkDataSourceImpl(

    private val apixuDogApiService: DogApiService
) : BreedNetworkDataSource {

    private val _downloadedCurrentBreed = MutableLiveData<List<CurrentBreedResponseItem>>()
    override val downloadedCurrentBreed: LiveData<List<CurrentBreedResponseItem>>
        get() = _downloadedCurrentBreed

    override suspend fun fetchCurrentBreed(name: String) {
        try {
            val fetchedCurrentBreed = apixuDogApiService
                .getCurrentBreed(name)
                .await()
            _downloadedCurrentBreed.postValue(fetchedCurrentBreed)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection.", e)
        }
    }
}