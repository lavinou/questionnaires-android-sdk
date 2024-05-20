package com.questionnaire.sdk.questionnaire.data.api.contract

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AnswerResponse(
    val id: String,
    val name: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String? = null
)
