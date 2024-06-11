package com.lavinou.questionnaire.questionnaire.data.repository

import com.lavinou.questionnaire.questionnaire.data.api.QuestionnaireApiService
import com.lavinou.questionnaire.questionnaire.domain.model.ActiveQuestionnaire
import com.lavinou.questionnaire.questionnaire.domain.repository.QuestionnaireRepository

internal class DefaultQuestionnaireRepository constructor(
    private val service: QuestionnaireApiService
) : QuestionnaireRepository {

    override val activeQuestionnaire: ActiveQuestionnaire?
        get() = null

}