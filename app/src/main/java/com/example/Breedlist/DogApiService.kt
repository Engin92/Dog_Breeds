package com.example.Breedlist

import com.example.Breedlist.network.ConnectivityInterceptor
import com.example.Breedlist.network.response.CurrentBreedResponseItem
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


//const val API_KEY = "f5758127-eae2-44e6-af2e-2fa0cee4bc59"
// e.g ?q=african to search for african - https://api.thedogapi.com/v1/breeds/search?q=african

interface DogApiService {

    @Headers("x-api-key: f5758127-eae2-44e6-af2e-2fa0cee4bc59")
    @GET("search")
    fun getCurrentBreed(
        @Query("q") name: String
    ): Deferred<List<CurrentBreedResponseItem>>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): DogApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.thedogapi.com/v1/breeds/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DogApiService::class.java)
        }
    }
}