package io.andrewgarner.retrokdroid.net

import io.andrewgarner.retrokdroid.model.ImageData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ImageApiService {
    @GET("image")
    fun getImageData(): Call<ImageData>
}

/**
 * Api for making call to get image.
 * See [ImageApiService]
 */
class ImageApi {

    fun getImage(callback: Callback<ImageData>) {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://private-060e33-retrodroid.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ImageApiService::class.java)
        val call = service.getImageData()

        call.enqueue(callback)
    }
}