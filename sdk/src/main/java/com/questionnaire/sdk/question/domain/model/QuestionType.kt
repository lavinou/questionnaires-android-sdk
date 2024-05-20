package com.questionnaire.sdk.question.domain.model

internal enum class QuestionType {
    TEXT,
    RADIO,
    BOOLEAN,
    CHECKBOX,
    SELECT;

    companion object {

        fun from(value: String): QuestionType {
            return when (value) {
                "text" -> TEXT
                "radio" -> RADIO
                "boolean" -> BOOLEAN
                "checkbox" -> CHECKBOX
                "select" -> SELECT
                else -> TEXT
            }
        }
    }
}