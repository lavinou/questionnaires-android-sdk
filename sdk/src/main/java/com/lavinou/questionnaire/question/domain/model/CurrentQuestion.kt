package com.lavinou.questionnaire.question.domain.model

internal data class CurrentQuestion(
    val status: QuestionStatus,
    val previous: String?,
    val question: Question? = null
)