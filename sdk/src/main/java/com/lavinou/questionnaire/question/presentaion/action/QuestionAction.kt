package com.lavinou.questionnaire.question.presentaion.action

internal sealed interface QuestionAction {

    data class GetCurrentQuestion(
        val questionnaireId: String,
        val takerId: String
    ) : QuestionAction

    data class GetNextQuestion(
        val questionnaireId: String,
        val takerId: String
    ) : QuestionAction

    data class GetPreviousQuestion(
        val questionnaireId: String,
        val takerId: String
    ) : QuestionAction

    data class OnBooleanAnswerChange(
        val id: String
    ) : QuestionAction

    data class OnRadioAnswerChange(
        val id: String
    ) : QuestionAction

    data class OnCheckBoxAnswerChange(
        val id: String
    ) : QuestionAction

    data class OnTextAnswerChange(
        val data: String,
        val id: String
    ) : QuestionAction

    data class OnSelectAnswerChange(
        val id: String
    ) : QuestionAction
}