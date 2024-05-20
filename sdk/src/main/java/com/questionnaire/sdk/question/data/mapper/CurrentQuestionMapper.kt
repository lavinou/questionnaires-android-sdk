package com.questionnaire.sdk.question.data.mapper

import com.questionnaire.sdk.question.data.api.contract.CurrentQuestionResponse
import com.questionnaire.sdk.question.domain.model.CurrentQuestion
import com.questionnaire.sdk.question.domain.model.QuestionStatus

internal fun CurrentQuestionResponse.toCurrentQuestion(): CurrentQuestion {
    return CurrentQuestion(
        status = QuestionStatus.from(status),
        previous = previous,
        question = question?.toQuestion()
    )
}