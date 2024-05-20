package com.questionnaire.sdk.question.data.api

import com.questionnaire.sdk.core.api.ApiClient
import com.questionnaire.sdk.core.api.get
import com.questionnaire.sdk.core.api.post
import com.questionnaire.sdk.question.data.api.contract.CurrentQuestionResponse
import com.questionnaire.sdk.question.data.api.contract.NextQuestionRequest

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