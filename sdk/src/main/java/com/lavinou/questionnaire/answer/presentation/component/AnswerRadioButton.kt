package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction
import com.lavinou.questionnaire.question.presentaion.action.QuestionAction

@Composable
internal fun AnswerRadioButton(
    selected: Boolean,
    onClick: (AnswerAction.OnRadioAnswerChange) -> Unit,
    answer: Answer,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = {
            onClick(
                AnswerAction.OnRadioAnswerChange(
                    id = answer.id
                )
            )
        })
        AnswerText(answer)
    }
}