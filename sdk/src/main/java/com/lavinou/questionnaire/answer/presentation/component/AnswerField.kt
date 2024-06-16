package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer
import com.lavinou.questionnaire.answer.domain.model.AnswerType
import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction

@Composable
internal fun AnswerField(
    answers: List<Answer>,
    answerType: AnswerType,
    selectedAnswers: List<CurrentAnswer>,
    onAction: (AnswerAction) -> Unit,
    modifier: Modifier = Modifier
) {
    answers.map { answer ->
        when (answerType) {
            AnswerType.TEXT -> {
                AnswerTextField(
                    value = selectedAnswers.firstOrNull { it.id == answer.id }?.value ?: "",
                    onChange = onAction,
                    answer = answer,
                    modifier = modifier
                )
            }

            AnswerType.RADIO -> {
                AnswerRadioButton(
                    selected = selectedAnswers.map { answer -> answer.id }
                        .contains(answer.id),
                    onClick = onAction,
                    answer = answer,
                    modifier = modifier
                )

            }

            AnswerType.BOOLEAN -> {
                AnswerBooleanField(
                    selected = selectedAnswers.map { answer -> answer.id }.contains(answer.id),
                    onChange = onAction,
                    answer = answer,
                    modifier = modifier
                )
            }

            AnswerType.CHECKBOX -> {
                AnswerCheckboxField(
                    checked = selectedAnswers.map { answer -> answer.id }
                        .contains(answer.id),
                    onChange = onAction,
                    answer = answer,
                    modifier = modifier
                )
            }

            AnswerType.SELECT -> {
                // TODO: Not yet supported
            }
        }
    }
}