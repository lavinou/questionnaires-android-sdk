package com.questionnaire.sdk.questionnaire.domain.model

import java.time.Instant

internal data class Question(
    val id: String,
    val questionnaireId: String,
    val name: String,
    val type: QuestionType,
    val answers: List<Answer>,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)
