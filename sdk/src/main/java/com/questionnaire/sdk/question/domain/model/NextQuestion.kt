package com.questionnaire.sdk.question.domain.model

import com.questionnaire.sdk.answer.domain.model.CurrentAnswer

typealias QuestionId = String
typealias AnswerId = String


data class NextQuestion(
    val current: QuestionId,
    val answers: List<CurrentAnswer>
)