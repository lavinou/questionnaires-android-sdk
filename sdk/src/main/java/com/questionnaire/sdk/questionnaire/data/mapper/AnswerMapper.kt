package com.questionnaire.sdk.questionnaire.data.mapper

import com.questionnaire.sdk.questionnaire.data.api.contract.AnswerResponse
import com.questionnaire.sdk.answer.domain.model.Answer

internal fun AnswerResponse.toAnswer(): Answer {
    return Answer(
        name = name,
        id = id
    )
}