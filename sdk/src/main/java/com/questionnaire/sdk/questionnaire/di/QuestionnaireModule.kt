package com.questionnaire.sdk.questionnaire.di

import com.questionnaire.sdk.questionnaire.data.api.QuestionnaireApiService
import com.questionnaire.sdk.questionnaire.data.repository.DefaultQuestionnaireRepository
import com.questionnaire.sdk.questionnaire.domain.repository.QuestionnaireRepository
import com.questionnaire.sdk.questionnaire.presentation.viewmodel.QuestionnaireViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal fun questionnaireModule() = module {
    single {
        QuestionnaireApiService(
            apiClient = get()
        )
    }

    single<QuestionnaireRepository> {
        DefaultQuestionnaireRepository(
            service = get()
        )
    }

    viewModel {
        QuestionnaireViewModel(
            repository = get()
        )
    }
}