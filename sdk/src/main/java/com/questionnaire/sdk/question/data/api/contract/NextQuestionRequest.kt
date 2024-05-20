package com.questionnaire.sdk.question.data.api.contract

import kotlinx.serialization.Serializable

@Serializable
data class NextQuestionRequest(
    val current: String,
    val answers: List<String>
)
