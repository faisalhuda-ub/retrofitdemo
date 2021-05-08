package com.learn.retrofitdemo.model

import retrofit2.Call
import retrofit2.http.GET

interface PostServices {
    @GET("posts")
    fun getPost(): Call<List<PostModel>>
}

