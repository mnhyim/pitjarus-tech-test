package com.mnhyim.data.di

import com.mnhyim.data.BuildConfig
import com.mnhyim.data.repository.UserRepositoryImpl
import com.mnhyim.data.source.UserApi
import com.mnhyim.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRepositories(
        api: UserApi
    ): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApi(): UserApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_LINK)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(UserApi::class.java)
    }

}