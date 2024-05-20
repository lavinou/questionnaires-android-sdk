package com.questionnaire.sdk.question.data.mapper

import com.questionnaire.sdk.question.data.api.contract.CurrentAnswerRequest
import com.questionnaire.sdk.question.data.api.contract.NextQuestionRequest
import com.questionnaire.sdk.question.domain.model.NextQuestion

internal fun NextQuestion.toRequest(): NextQuestionRequest {
    return NextQuestionRequest(
        current = current,
        answers = answers.map { CurrentAnswerRequest(it.id, it.value) }
    )
}