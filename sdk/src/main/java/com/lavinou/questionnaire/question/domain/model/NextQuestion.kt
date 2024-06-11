package com.lavinou.questionnaire.question.domain.model

import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer

internal typealias QuestionId = String

internal data class NextQuestion(
    val current: QuestionId,
    val answers: List<CurrentAnswer>
)