package com.lavinou.questionnaire

sealed interface QuestionnaireResult {

    data object Complete : QuestionnaireResult

    data object NotShown : QuestionnaireResult

    data object AlreadyShown : QuestionnaireResult

    data object Failed : QuestionnaireResult
}