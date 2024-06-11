package com.lavinou.questionnaire.question.data.mapper

import com.lavinou.questionnaire.question.data.api.contract.CurrentAnswerRequest
import com.lavinou.questionnaire.question.data.api.contract.NextQuestionRequest
import com.lavinou.questionnaire.question.domain.model.NextQuestion

internal fun NextQuestion.toRequest(): NextQuestionRequest {
    return NextQuestionRequest(
        current = current,
        answers = answers.map { CurrentAnswerRequest(it.id, it.value) }
    )
}