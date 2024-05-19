package com.questionnaire.sdk.questionnaire.domain.model

internal data class CurrentQuestion(
    val status: String,
    val previous: String,
    val question: Question
)
