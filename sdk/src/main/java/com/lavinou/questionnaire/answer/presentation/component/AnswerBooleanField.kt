package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction

@Composable
internal fun AnswerBooleanField(
    selected: Boolean,
    onChange: (AnswerAction.OnBooleanAnswerChange) -> Unit,
    answer: Answer,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = {
            onChange(
                AnswerAction.OnBooleanAnswerChange(
                    id = answer.id
                )
            )
        })
        AnswerText(answer)
    }
}