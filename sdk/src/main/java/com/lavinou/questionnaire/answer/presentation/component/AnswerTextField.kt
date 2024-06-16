package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction

@Composable
internal fun AnswerTextField(
    value: String?,
    onChange: (AnswerAction.OnTextAnswerChange) -> Unit,
    answer: Answer,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value ?: "",
        onValueChange = { value ->
            onChange(
                AnswerAction.OnTextAnswerChange(
                    data = value,
                    id = answer.id
                )
            )
        })
}