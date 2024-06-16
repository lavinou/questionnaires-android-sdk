package com.lavinou.questionnaire.answer.domain.model

internal enum class AnswerType {
    TEXT,
    RADIO,
    BOOLEAN,
    CHECKBOX,
    SELECT;

    companion object {

        fun from(value: String): AnswerType {
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