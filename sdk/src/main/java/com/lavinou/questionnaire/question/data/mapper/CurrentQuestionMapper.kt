package com.lavinou.questionnaire.question.data.mapper

import com.lavinou.questionnaire.question.data.api.contract.CurrentQuestionResponse
import com.lavinou.questionnaire.question.domain.model.CurrentQuestion
import com.lavinou.questionnaire.question.domain.model.QuestionStatus

internal fun CurrentQuestionResponse.toCurrentQuestion(): CurrentQuestion {
    return CurrentQuestion(
        status = QuestionStatus.from(status),
        previous = previous,
        question = question?.toQuestion()
    )
}