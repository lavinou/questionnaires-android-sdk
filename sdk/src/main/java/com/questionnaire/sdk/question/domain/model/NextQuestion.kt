package com.questionnaire.sdk.question.domain.model

typealias QuestionId = String
typealias AnswerId = String


data class NextQuestion(
    val current: QuestionId,
    val answers: List<AnswerId>
)