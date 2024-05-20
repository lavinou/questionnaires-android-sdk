package com.questionnaire.sdk.questionnaire.data.repository

import com.questionnaire.sdk.questionnaire.data.api.QuestionnaireApiService
import com.questionnaire.sdk.question.data.mapper.toCurrentQuestion
import com.questionnaire.sdk.questionnaire.domain.model.ActiveQuestionnaire
import com.questionnaire.sdk.question.domain.model.CurrentQuestion
import com.questionnaire.sdk.question.domain.model.NextQuestion
import com.questionnaire.sdk.questionnaire.domain.repository.QuestionnaireRepository

internal class DefaultQuestionnaireRepository constructor(
    private val service: QuestionnaireApiService
): QuestionnaireRepository {

    override val activeQuestionnaire: ActiveQuestionnaire?
        get() = null

    override suspend fun reset() {
        TODO("Not yet implemented")
    }

    override suspend fun previousQuestion(): CurrentQuestion {
        TODO("Not yet implemented")
    }

    override suspend fun currentQuestion(questionnaireId: String,takerId: String): CurrentQuestion {
        TODO("Not yet implemented")
    }

    override suspend fun nextQuestion(next: NextQuestion): CurrentQuestion {
        TODO("Not yet implemented")
    }

}