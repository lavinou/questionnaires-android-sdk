package com.questionnaire.sdk.question.di

import com.questionnaire.sdk.question.data.api.QuestionApiService
import com.questionnaire.sdk.question.data.repository.DefaultQuestionRepository
import com.questionnaire.sdk.question.domain.repository.QuestionRepository
import com.questionnaire.sdk.question.presentaion.viewmodel.QuestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal fun questionModule() = module {

    single {
        QuestionApiService(
            apiClient = get()
        )
    }

    single<QuestionRepository> {
        DefaultQuestionRepository(
            service = get()
        )
    }

    viewModel {
        QuestionViewModel(
            repository = get()
        )
    }


}