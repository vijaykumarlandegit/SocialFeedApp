package com.practice.socialfeed.di

import dagger.hilt.components.SingletonComponent
import com.practice.socialfeed.data.remote.PostApi
import com.practice.socialfeed.data.remote.PostRepository
import com.practice.socialfeed.data.repository.PostRepositoryImpl
import dagger.hilt.InstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
 

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "apiUrl"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePostApi(
        retrofit: Retrofit
    ): PostApi = retrofit.create(PostApi::class.java)

    @Provides
    @Singleton
    fun providePostRepository(
        api: PostApi
    ): PostRepository = PostRepositoryImpl(api)

    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}