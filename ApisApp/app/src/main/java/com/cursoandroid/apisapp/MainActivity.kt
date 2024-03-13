package com.cursoandroid.apisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.cursoandroid.apisapp.api.TheCatApiService
import com.cursoandroid.apisapp.models.ImageResultData
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val breedName by lazy { findViewById<TextView>(R.id.main_activity_tvBreed) }
    private val breedTemperament by lazy { findViewById<TextView>(R.id.main_activity_tvTemperament) }
    private val breedImage by lazy { findViewById<ImageView>(R.id.main_activity_IvImage) }


    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }

    private val theCatApiService by lazy { retrofit.create(TheCatApiService::class.java) }

    private val imageLoader by lazy {
        GlideImageLoader(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCatImageResponse()
    }

    private fun getCatImageResponse() {

        val call = theCatApiService.searchImages(1, "full")

        call.enqueue(object : Callback<List<ImageResultData>> {
            override fun onFailure(call: Call<List<ImageResultData>>, t: Throwable) {
                Log.e("APU", "Fallo en la obtencion de datos")
            }

            override fun onResponse(
                call: Call<List<ImageResultData>>, response: Response<List<ImageResultData>>
            ) {
                if (response.isSuccessful) {

                    val imageResults = response.body()
                    val firstImageUrl = imageResults?.firstOrNull()?.imageUrl ?: ""

                    if (firstImageUrl.isNotBlank()) {
                        imageLoader.loadImage(firstImageUrl, breedImage)
                    }
                    else {
                        Log.d("APU", "Missing image URL")
                    }

                } else {
                    Log.d("APU", "Error: ${response.errorBody()?.string() ?: ""}")
                }
            }
        })
    }
}