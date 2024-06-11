package com.lavinou.questionnaire.question.data.api.contract

import kotlinx.serialization.Serializable

@Serializable
internal data class CurrentQuestionResponse(
    val status: String,
    val previous: String? = null,
    val question: QuestionResponse? = null
)
