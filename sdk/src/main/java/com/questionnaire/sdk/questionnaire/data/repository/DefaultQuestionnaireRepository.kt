package com.questionnaire.sdk.questionnaire.data.repository

import com.questionnaire.sdk.questionnaire.data.api.QuestionnaireApiService
import com.questionnaire.sdk.questionnaire.domain.model.ActiveQuestionnaire
import com.questionnaire.sdk.questionnaire.domain.repository.QuestionnaireRepository

internal class DefaultQuestionnaireRepository constructor(
    private val service: QuestionnaireApiService
) : QuestionnaireRepository {

    override val activeQuestionnaire: ActiveQuestionnaire?
        get() = null

}