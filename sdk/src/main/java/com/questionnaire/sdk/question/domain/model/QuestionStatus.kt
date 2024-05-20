package com.questionnaire.sdk.question.domain.model

internal enum class QuestionStatus {
    RESET,
    STARTED,
    COMPLETED;

    companion object {

        fun from(value: String): QuestionStatus {
            return when (value) {
                "started" -> STARTED
                "completed" -> COMPLETED
                "reset" -> RESET
                else -> STARTED
            }
        }
    }
}