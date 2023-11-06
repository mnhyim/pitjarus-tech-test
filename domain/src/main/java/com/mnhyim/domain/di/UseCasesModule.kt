package com.mnhyim.domain.di

import com.mnhyim.domain.repository.UserRepository
import com.mnhyim.domain.usecase.AuthUseCases
import com.mnhyim.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @ViewModelScoped
    @Provides
    fun provideAuthUseCases(repository: UserRepository): AuthUseCases {
        return AuthUseCases(
            LoginUseCase(repository)
        )
    }
}