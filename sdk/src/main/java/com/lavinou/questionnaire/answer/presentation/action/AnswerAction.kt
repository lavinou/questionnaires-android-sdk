package com.lavinou.questionnaire.answer.presentation.action

internal sealed interface AnswerAction {

    data object OnClearAnswers: AnswerAction

    data class OnBooleanAnswerChange(
        val id: String
    ) : AnswerAction

    data class OnRadioAnswerChange(
        val id: String
    ) : AnswerAction

    data class OnCheckBoxAnswerChange(
        val id: String
    ) : AnswerAction

    data class OnTextAnswerChange(
        val data: String,
        val id: String
    ) : AnswerAction

    data class OnSelectAnswerChange(
        val id: String
    ) : AnswerAction
}