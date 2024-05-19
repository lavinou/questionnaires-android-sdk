package com.questionnaire.sdk.questionnaire.domain.model


typealias QuestionId = String
typealias AnswerId = String
data class NextQuestion(
    val current: QuestionId,
    val answer: List<AnswerId>
)
