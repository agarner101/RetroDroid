package io.andrewgarner.retrokdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import io.andrewgarner.retrokdroid.model.ImageData
import io.andrewgarner.retrokdroid.net.ImageApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val logTag = MainActivity::class.java.simpleName

    private lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImageView = findViewById(R.id.image)

        ImageApi().getImage(object : Callback<ImageData> {
            override fun onResponse(call: Call<ImageData>?, response: Response<ImageData>?) {
                val data: ImageData? = response?.body()
                if (data != null) {
                    Log.d(logTag, "Response with imageUrl: " + data.url)
                    showImage(data)
                } else {
                    showError()
                }
            }

            override fun onFailure(call: Call<ImageData>?, t: Throwable?) {
                showError()
            }

        })
    }

    private fun showImage(data: ImageData) {
        val url = data.url
        Picasso.get().load(url).into(mImageView)
    }

    private fun showError() {
        Log.e(logTag, "API Error")
        Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
    }
}
