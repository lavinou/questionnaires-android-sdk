package com.questionnaire.sdk.user.domain.model

internal data class User(
    val id: String,
    val email: String? = null,
    val phone: String? = null,
    val properties: Map<String, String> = emptyMap(),
    val isAnonymous: Boolean = false
)
