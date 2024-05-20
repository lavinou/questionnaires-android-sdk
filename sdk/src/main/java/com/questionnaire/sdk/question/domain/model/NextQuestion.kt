package com.questionnaire.sdk.question.domain.model

import com.questionnaire.sdk.answer.domain.model.CurrentAnswer

internal typealias QuestionId = String

internal data class NextQuestion(
    val current: QuestionId,
    val answers: List<CurrentAnswer>
)