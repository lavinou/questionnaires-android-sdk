package com.questionnaire.sdk.question.presentaion.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.questionnaire.sdk.answer.presentation.component.AnswerView
import com.questionnaire.sdk.question.domain.model.AnswerId
import com.questionnaire.sdk.question.domain.model.Question
import com.questionnaire.sdk.question.domain.model.QuestionType
import com.questionnaire.sdk.question.presentaion.action.QuestionAction

@Composable
internal fun QuestionView(
    question: Question,
    selectedAnswers: List<AnswerId>,
    onAction: (QuestionAction) -> Unit
) {

    Column {
        Text(
            text = question.name,
            style = MaterialTheme.typography.titleMedium
        )

        question.answers.map { answer ->
            when (question.type) {
                QuestionType.TEXT -> {

                }

                QuestionType.RADIO -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedAnswers.contains(answer.id), onClick = {
                            onAction(
                                QuestionAction.OnRadioAnswerChange(
                                    id = answer.id
                                )
                            )
                        })
                        AnswerView(answer)
                    }
                }

                QuestionType.BOOLEAN -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedAnswers.contains(answer.id), onClick = {
                            onAction(
                                QuestionAction.OnBooleanAnswerChange(
                                    id = answer.id
                                )
                            )
                        })
                        AnswerView(answer)
                    }
                }

                QuestionType.CHECKBOX -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = selectedAnswers.contains(answer.id), onCheckedChange = {
                            onAction(
                                QuestionAction.OnCheckBoxAnswerChange(
                                    id = answer.id
                                )
                            )
                        })
                        AnswerView(answer)
                    }
                }

                QuestionType.SELECT -> {

                }
            }
        }

    }

}