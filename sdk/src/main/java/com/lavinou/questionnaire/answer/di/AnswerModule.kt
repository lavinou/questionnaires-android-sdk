package com.lavinou.questionnaire.answer.di

import com.lavinou.questionnaire.answer.presentation.viewmodel.AnswerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal fun answerModule() = module {
    viewModel { AnswerViewModel() }
}