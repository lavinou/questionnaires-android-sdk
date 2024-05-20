package com.questionnaire.sdk.questionnaire.domain.model

import com.questionnaire.sdk.question.domain.model.Question

internal data class ActiveQuestionnaire(
    val id: String,
    val name: String,
    val questions: List<Question>
)
