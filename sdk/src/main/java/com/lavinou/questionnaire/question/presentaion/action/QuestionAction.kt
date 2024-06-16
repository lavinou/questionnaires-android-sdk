package com.lavinou.questionnaire.question.presentaion.action

import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer

internal sealed interface QuestionAction {

    data class GetCurrentQuestion(
        val questionnaireId: String,
        val takerId: String
    ) : QuestionAction

    data class GetNextQuestion(
        val questionnaireId: String,
        val takerId: String,
        val answers: List<CurrentAnswer>
    ) : QuestionAction

    data class GetPreviousQuestion(
        val questionnaireId: String,
        val takerId: String
    ) : QuestionAction

}