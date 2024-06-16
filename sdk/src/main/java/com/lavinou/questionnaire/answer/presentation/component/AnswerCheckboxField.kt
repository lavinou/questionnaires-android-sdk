package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction

@Composable
internal fun AnswerCheckboxField(
    checked: Boolean,
    onChange: (AnswerAction.OnCheckBoxAnswerChange) -> Unit,
    answer: Answer,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = {
            onChange(
                AnswerAction.OnCheckBoxAnswerChange(
                    id = answer.id
                )
            )
        })
        AnswerText(answer)
    }
}