package com.lavinou.questionnaire.questionnaire.domain.model

import com.lavinou.questionnaire.question.domain.model.Question

internal data class ActiveQuestionnaire(
    val id: String,
    val name: String,
    val questions: List<Question>
)
