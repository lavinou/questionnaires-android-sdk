package com.questionnaire.sdk.question.presentaion.state

import com.questionnaire.sdk.question.domain.model.AnswerId
import com.questionnaire.sdk.question.domain.model.Question
import com.questionnaire.sdk.question.domain.model.QuestionStatus

internal data class QuestionState(
    val question: Question? = null,
    val previous: String? = null,
    val answers: List<AnswerId> = emptyList(),
    val status: QuestionStatus = QuestionStatus.STARTED
)
