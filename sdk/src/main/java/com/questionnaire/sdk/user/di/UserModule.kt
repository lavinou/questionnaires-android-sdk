package com.questionnaire.sdk.user.di

import android.content.Context
import com.questionnaire.sdk.user.data.api.UserApiService
import com.questionnaire.sdk.user.data.repository.DefaultUserRepository
import com.questionnaire.sdk.user.domain.repository.UserRepository
import com.questionnaire.sdk.user.domain.usecase.GetOrCreateUserUseCase
import org.koin.dsl.module

fun userModule(context: Context) = module {

    single { UserApiService(
        apiClient = get()
    ) }

    single<UserRepository>{ DefaultUserRepository(
        service = get()
    ) }

    factory { GetOrCreateUserUseCase(
        repository = get()
    ) }
}