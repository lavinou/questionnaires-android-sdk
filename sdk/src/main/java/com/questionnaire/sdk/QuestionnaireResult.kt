package com.questionnaire.sdk

sealed interface QuestionnaireResult {

    object Complete: QuestionnaireResult

    object NotShown: QuestionnaireResult

    object AlreadyShown: QuestionnaireResult

    object Failed: QuestionnaireResult
}