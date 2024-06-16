package com.lavinou.questionnaire.question.di

import com.lavinou.questionnaire.question.data.api.QuestionApiService
import com.lavinou.questionnaire.question.data.repository.DefaultQuestionRepository
import com.lavinou.questionnaire.question.domain.repository.QuestionRepository
import com.lavinou.questionnaire.question.domain.usecase.GetCurrentQuestionUseCase
import com.lavinou.questionnaire.question.presentaion.viewmodel.QuestionViewModel
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

    factory {
        GetCurrentQuestionUseCase(
            repository = get()
        )
    }

    viewModel {
        QuestionViewModel(
            repository = get(),
            getCurrentQuestionUseCase = get()
        )
    }


}