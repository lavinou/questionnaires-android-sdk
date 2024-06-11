package com.lavinou.questionnaire.question.domain.repository

import com.lavinou.questionnaire.question.domain.model.CurrentQuestion
import com.lavinou.questionnaire.question.domain.model.NextQuestion

internal interface QuestionRepository {

    suspend fun currentQuestion(
        questionnaireId: String,
        takerId: String
    ): CurrentQuestion

    suspend fun nextQuestion(
        questionnaireId: String,
        takerId: String,
        next: NextQuestion
    ): CurrentQuestion

    suspend fun previousQuestion(
        questionnaireId: String,
        takerId: String
    ): CurrentQuestion
}