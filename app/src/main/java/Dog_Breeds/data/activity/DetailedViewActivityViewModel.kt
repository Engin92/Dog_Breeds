package Dog_Breeds.data.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import Dog_Breeds.data.network.response.CurrentBreedResponseItem

class DetailedViewActivityViewModel : ViewModel() {

    var detailedViewActivityRepository: DetailedViewActivityRepository

    init {
        detailedViewActivityRepository =
            DetailedViewActivityRepository()
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