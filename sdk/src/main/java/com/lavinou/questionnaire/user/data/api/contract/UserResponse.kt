package com.lavinou.questionnaire.user.data.api.contract

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class UserResponse(
    val id: String,
    val email: String,
    val status: String,
    @SerialName("created_at")
    val createdAt: String
)
