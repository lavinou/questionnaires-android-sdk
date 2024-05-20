package com.questionnaire.sdk.question.presentaion.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

        when(question.type) {
            QuestionType.TEXT -> TODO()
            QuestionType.RADIO -> {
                question.answers.map {
                    Row {
                        RadioButton(selected = true , onClick = {  })
                        AnswerView(it)
                    }

                }
            }
            QuestionType.BOOLEAN -> {
                question.answers.map {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedAnswers.contains(it.id) , onClick = {
                            onAction(QuestionAction.OnBooleanAnswerChange(
                                id = it.id
                            ))
                        })
                        AnswerView(it)
                    }

                }
            }
            QuestionType.CHECKBOX -> {

            }
            QuestionType.SELECT -> {

            }
        }
    }

}