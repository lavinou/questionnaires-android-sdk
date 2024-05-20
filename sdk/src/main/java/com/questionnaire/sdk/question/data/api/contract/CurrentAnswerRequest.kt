package com.questionnaire.sdk.question.data.api.contract

import kotlinx.serialization.Serializable

@Serializable
data class CurrentAnswerRequest(
    val id: String,
    val value: String? = null
)
