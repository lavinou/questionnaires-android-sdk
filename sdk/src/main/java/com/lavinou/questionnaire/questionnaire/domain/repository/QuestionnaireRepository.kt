package com.lavinou.questionnaire.questionnaire.domain.repository

import com.lavinou.questionnaire.questionnaire.domain.model.ActiveQuestionnaire

internal interface QuestionnaireRepository {

    val activeQuestionnaire: ActiveQuestionnaire?

}