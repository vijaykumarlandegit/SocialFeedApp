package com.practice.socialfeed.data.remote

import com.practice.socialfeed.data.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun addPost(content: String): Post
}