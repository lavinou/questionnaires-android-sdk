package com.lavinou.questionnaire.questionnaire.di

import com.lavinou.questionnaire.questionnaire.data.api.QuestionnaireApiService
import com.lavinou.questionnaire.questionnaire.data.repository.DefaultQuestionnaireRepository
import com.lavinou.questionnaire.questionnaire.domain.repository.QuestionnaireRepository
import com.lavinou.questionnaire.questionnaire.presentation.viewmodel.QuestionnaireViewModel
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