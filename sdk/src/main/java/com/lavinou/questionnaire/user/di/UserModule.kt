package com.lavinou.questionnaire.user.di

import android.content.Context
import com.lavinou.questionnaire.user.UserManager
import com.lavinou.questionnaire.user.data.api.UserApiService
import com.lavinou.questionnaire.user.data.repository.DefaultUserRepository
import com.lavinou.questionnaire.user.domain.repository.UserRepository
import com.lavinou.questionnaire.user.domain.usecase.GetOrCreateUserUseCase
import com.lavinou.questionnaire.user.presentation.viewmodel.UserViewModel
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