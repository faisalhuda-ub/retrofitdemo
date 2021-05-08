package com.learn.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.learn.retrofitdemo.model.DataRepository
import com.learn.retrofitdemo.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postServices = DataRepository.create()

        postServices.getPost().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("WEBSERVICE", "data : ${data?.size}")

                    data?.map {
                        Log.d("WEBSERVICE", "data ${it.body}")
                    }
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.e("ERROR", "Errornya ${t.message}")
            }
        })
    }
}