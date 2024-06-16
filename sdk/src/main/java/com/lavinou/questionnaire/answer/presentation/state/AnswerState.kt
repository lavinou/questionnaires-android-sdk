package com.lavinou.questionnaire.answer.presentation.state

import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer

internal data class AnswerState(
    val answers: List<CurrentAnswer> = emptyList(),
)
