package com.example.apicomposedemo.data
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<com.example.apicomposedemo.model.Post>
}
