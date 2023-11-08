package com.mnhyim.data.di

import com.mnhyim.data.repository.StoreRepositoryImpl
import com.mnhyim.data.repository.UserRepositoryImpl
import com.mnhyim.data.source.local.database.AppDatabase
import com.mnhyim.data.source.remote.UserApi
import com.mnhyim.domain.repository.StoreRepository
import com.mnhyim.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideUserRepositories(
        api: UserApi,
        database: AppDatabase
    ): UserRepository {
        return UserRepositoryImpl(api, database)
    }

    @Provides
    @Singleton
    fun provideStoreRepositories(
        database: AppDatabase
    ): StoreRepository {
        return StoreRepositoryImpl(database)
    }
}