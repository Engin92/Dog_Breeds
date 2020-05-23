package com.example.Breedlist.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.Breedlist.activity.DetailedViewActivityRepository
import com.example.Breedlist.network.response.CurrentBreedResponseItem

class DetailedViewActivityViewModel : ViewModel() {

    var detailedViewActivityRepository: DetailedViewActivityRepository

    init {
        detailedViewActivityRepository = DetailedViewActivityRepository()
    }

    fun getBreedsFromAPIAndStore()
    {
        detailedViewActivityRepository.ApiCallAndPutInDB()
    }

    fun getAllBreedList(): LiveData<List<CurrentBreedResponseItem>>
    {
        return detailedViewActivityRepository.getBreeds()
    }
}