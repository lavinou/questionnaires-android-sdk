package com.lavinou.questionnaire.question.presentaion.state

import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer
import com.lavinou.questionnaire.question.domain.model.Question
import com.lavinou.questionnaire.question.domain.model.QuestionStatus

internal data class QuestionState(
    val question: Question? = null,
    val previous: String? = null,
    val answers: List<CurrentAnswer> = emptyList(),
    val status: QuestionStatus = QuestionStatus.STARTED
)
