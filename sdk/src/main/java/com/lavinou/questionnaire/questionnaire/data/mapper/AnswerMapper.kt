package com.lavinou.questionnaire.questionnaire.data.mapper

import com.lavinou.questionnaire.questionnaire.data.api.contract.AnswerResponse
import com.lavinou.questionnaire.answer.domain.model.Answer

internal fun AnswerResponse.toAnswer(): Answer {
    return Answer(
        name = name,
        id = id
    )
}