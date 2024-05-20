package com.questionnaire.sdk.question.presentaion.action

import com.questionnaire.sdk.question.domain.model.NextQuestion
import com.questionnaire.sdk.question.domain.model.QuestionType

sealed interface QuestionAction {

    data class GetCurrentQuestion(
        val questionnaireId: String
    ): QuestionAction

    data class GetNextQuestion(
        val questionnaireId: String,
    ): QuestionAction

    data class GetPreviousQuestion(
        val questionnaireId: String
    ): QuestionAction

    data class OnBooleanAnswerChange(
        val id: String
    ): QuestionAction

    data class OnRadioAnswerChange(
        val id: String
    ): QuestionAction

    data class OnCheckBoxAnswerChange(
        val id: String
    ): QuestionAction

    data class OnTextAnswerChange(
        val data: String,
        val id: String
    ): QuestionAction

    data class OnSelectAnswerChange(
        val id: String
    ): QuestionAction
}