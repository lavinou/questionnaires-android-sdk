package com.lavinou.questionnaire.question.data.api.contract

import com.lavinou.questionnaire.questionnaire.data.api.contract.AnswerResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class QuestionResponse(
    val id: String,
    val name: String,
    val type: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String? = null,
    @SerialName("questionnaire")
    val questionnaireId: String,
    val answers: List<AnswerResponse>
)
