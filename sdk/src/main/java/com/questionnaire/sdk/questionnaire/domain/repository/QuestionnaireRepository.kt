package com.questionnaire.sdk.questionnaire.domain.repository

import com.questionnaire.sdk.questionnaire.domain.model.ActiveQuestionnaire
import com.questionnaire.sdk.questionnaire.domain.model.CurrentQuestion
import com.questionnaire.sdk.questionnaire.domain.model.NextQuestion

internal interface QuestionnaireRepository {

    val activeQuestionnaire: ActiveQuestionnaire?

    suspend fun currentQuestion(userId: String): CurrentQuestion

    suspend fun nextQuestion(next: NextQuestion): CurrentQuestion

    suspend fun previousQuestion(): CurrentQuestion

    suspend fun reset()

}