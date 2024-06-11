package com.lavinou.questionnaire.question.domain.model

import com.lavinou.questionnaire.answer.domain.model.Answer
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