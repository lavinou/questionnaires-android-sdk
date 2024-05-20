package com.questionnaire.sdk.questionnaire.domain.repository

import com.questionnaire.sdk.questionnaire.domain.model.ActiveQuestionnaire

internal interface QuestionnaireRepository {

    val activeQuestionnaire: ActiveQuestionnaire?

}