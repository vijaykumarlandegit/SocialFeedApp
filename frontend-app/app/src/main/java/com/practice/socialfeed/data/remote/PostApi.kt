package com.practice.socialfeed.data.remote
import com.practice.socialfeed.data.model.CreatePostRequest
import com.practice.socialfeed.data.model.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostResponse>

    @POST("/posts")
    suspend fun addPost(
        @Body body: CreatePostRequest
    ): PostResponse
}
