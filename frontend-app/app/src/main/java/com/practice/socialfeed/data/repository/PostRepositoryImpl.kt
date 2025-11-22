package com.practice.socialfeed.data.repository

import com.practice.socialfeed.data.model.CreatePostRequest
import com.practice.socialfeed.data.model.Post
import com.practice.socialfeed.data.remote.PostApi
import com.practice.socialfeed.data.remote.PostRepository

class PostRepositoryImpl(
    private val api: PostApi
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        val response = api.getPosts()
        return response.map { dto ->
            Post(
                id = dto.id,
                content = dto.content
            )
        }
    }

    override suspend fun addPost(content: String): Post {
        val created = api.addPost(CreatePostRequest(content))
        return Post(
            id = created.id,
            content = created.content
        )
    }
}
