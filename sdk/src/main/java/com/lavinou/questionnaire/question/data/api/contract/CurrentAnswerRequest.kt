package com.lavinou.questionnaire.question.data.api.contract

import kotlinx.serialization.Serializable

@Serializable
internal data class CurrentAnswerRequest(
    val id: String,
    val value: String? = null
)
