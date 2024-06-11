package com.lavinou.questionnaire.question.data.repository

import com.lavinou.questionnaire.question.data.api.QuestionApiService
import com.lavinou.questionnaire.question.data.mapper.toCurrentQuestion
import com.lavinou.questionnaire.question.data.mapper.toRequest
import com.lavinou.questionnaire.question.domain.model.CurrentQuestion
import com.lavinou.questionnaire.question.domain.model.NextQuestion
import com.lavinou.questionnaire.question.domain.repository.QuestionRepository

internal class DefaultQuestionRepository constructor(
    private val service: QuestionApiService
) : QuestionRepository {

    override suspend fun previousQuestion(
        questionnaireId: String,
        takerId: String
    ): CurrentQuestion {
        val current = service.previousQuestion(
            questionnaireId = questionnaireId,
            takerId = takerId
        )

        return current.toCurrentQuestion()
    }

    override suspend fun nextQuestion(
        questionnaireId: String,
        takerId: String,
        next: NextQuestion
    ): CurrentQuestion {
        val current = service.nextQuestion(
            questionnaireId = questionnaireId,
            takerId = takerId,
            request = next.toRequest()
        )

        return current.toCurrentQuestion()
    }

    override suspend fun currentQuestion(
        questionnaireId: String,
        takerId: String
    ): CurrentQuestion {
        val current = service.currentQuestion(
            questionnaireId = questionnaireId,
            takerId = takerId
        )

        return current.toCurrentQuestion()
    }
}