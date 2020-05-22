package com.example.Breedlist.network

import androidx.lifecycle.LiveData
import com.example.Breedlist.network.response.CurrentBreedResponseItem

interface BreedNetworkDataSource {
    val downloadedCurrentBreed: LiveData<List<CurrentBreedResponseItem>>

    suspend fun fetchCurrentBreed(
        name: String
    )
}