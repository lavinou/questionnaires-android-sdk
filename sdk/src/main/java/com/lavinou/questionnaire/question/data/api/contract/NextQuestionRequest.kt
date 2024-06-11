package com.lavinou.questionnaire.question.data.api.contract

import kotlinx.serialization.Serializable

@Serializable
internal data class NextQuestionRequest(
    val current: String,
    val answers: List<CurrentAnswerRequest>
)
