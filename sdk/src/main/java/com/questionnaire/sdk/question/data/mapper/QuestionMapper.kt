package com.questionnaire.sdk.question.data.mapper

import com.questionnaire.sdk.question.data.api.contract.QuestionResponse
import com.questionnaire.sdk.question.domain.model.Question
import com.questionnaire.sdk.question.domain.model.QuestionType
import com.questionnaire.sdk.questionnaire.data.mapper.toAnswer
import java.time.Instant

internal fun QuestionResponse.toQuestion(): Question {
    return Question(
        id = id,
        name = name,
        questionnaireId = questionnaireId,
        type = QuestionType.from(type),
        createdAt = Instant.parse(createdAt),
        updatedAt = if(updatedAt!=null) Instant.parse(updatedAt) else null,
        answers = answers.map { it.toAnswer() }
    )
}

