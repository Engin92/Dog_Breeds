package Dog_Breeds.data.retrofit

import Dog_Breeds.data.network.response.CurrentBreedResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RestApi {

    @Headers("x-api-key: f5758127-eae2-44e6-af2e-2fa0cee4bc59")
    @GET("search")
    fun getAllBreeds(
        @Query("q") name: String
    ) : Call<List<CurrentBreedResponseItem>>
}