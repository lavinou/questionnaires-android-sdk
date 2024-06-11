package com.lavinou.questionnaire.question.data.mapper

import com.lavinou.questionnaire.question.data.api.contract.QuestionResponse
import com.lavinou.questionnaire.question.domain.model.Question
import com.lavinou.questionnaire.question.domain.model.QuestionType
import com.lavinou.questionnaire.questionnaire.data.mapper.toAnswer
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

