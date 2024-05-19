package com.questionnaire.sdk.questionnaire.domain.model

internal data class ActiveQuestionnaire(
    val id: String,
    val name: String,
    val questions: List<Question>
)
