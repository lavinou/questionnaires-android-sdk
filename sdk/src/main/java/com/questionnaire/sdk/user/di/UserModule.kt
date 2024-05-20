package com.questionnaire.sdk.user.di

import android.content.Context
import com.questionnaire.sdk.user.UserManager
import com.questionnaire.sdk.user.data.api.UserApiService
import com.questionnaire.sdk.user.data.repository.DefaultUserRepository
import com.questionnaire.sdk.user.domain.repository.UserRepository
import com.questionnaire.sdk.user.domain.usecase.GetOrCreateUserUseCase
import com.questionnaire.sdk.user.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal fun userModule(context: Context) = module {

    single {
        UserApiService(
            apiClient = get()
        )
    }

    single<UserRepository> {
        DefaultUserRepository(
            service = get(),
            context = context
        )
    }

    factory {
        GetOrCreateUserUseCase(
            repository = get()
        )
    }

    single {
        UserManager(
            getOrCreateUserUseCase = get()
        )
    }

    viewModel {
        UserViewModel(
            manager = get()
        )
    }
}