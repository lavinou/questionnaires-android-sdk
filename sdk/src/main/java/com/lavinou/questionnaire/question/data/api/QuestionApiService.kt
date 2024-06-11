package com.lavinou.questionnaire.question.data.api

import com.lavinou.questionnaire.core.api.ApiClient
import com.lavinou.questionnaire.core.api.get
import com.lavinou.questionnaire.core.api.post
import com.lavinou.questionnaire.question.data.api.contract.CurrentQuestionResponse
import com.lavinou.questionnaire.question.data.api.contract.NextQuestionRequest

internal class QuestionApiService constructor(
    private val apiClient: ApiClient
) {

    suspend fun currentQuestion(questionnaireId: String, takerId: String): CurrentQuestionResponse {
        return apiClient.get<CurrentQuestionResponse>(
            "questionnaires/$questionnaireId/current/", queryParams = mapOf(
                "takerId" to takerId
            )
        ).getOrThrow()
    }

    suspend fun nextQuestion(
        questionnaireId: String,
        takerId: String,
        request: NextQuestionRequest
    ): CurrentQuestionResponse {
        return apiClient.post<NextQuestionRequest, CurrentQuestionResponse>(
            resource = "questionnaires/$questionnaireId/next/",
            queryParams = mapOf(
                "takerId" to takerId
            ),
            data = request
        ).getOrThrow()
    }

    suspend fun previousQuestion(
        questionnaireId: String,
        takerId: String
    ): CurrentQuestionResponse {
        return apiClient.get<CurrentQuestionResponse>(
            resource = "questionnaires/$questionnaireId/previous/",
            queryParams = mapOf(
                "takerId" to takerId
            )
        ).getOrThrow()
    }

}