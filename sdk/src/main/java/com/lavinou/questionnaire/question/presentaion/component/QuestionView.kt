package com.lavinou.questionnaire.question.presentaion.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction
import com.lavinou.questionnaire.answer.presentation.component.AnswerField
import com.lavinou.questionnaire.question.domain.model.Question

@Composable
internal fun QuestionView(
    question: Question,
    selectedAnswers: List<CurrentAnswer>,
    onAction: (AnswerAction) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            text = question.name,
            style = MaterialTheme.typography.titleMedium
        )

        AnswerField(
            answers = question.answers,
            answerType = question.type,
            selectedAnswers = selectedAnswers,
            onAction = onAction
        )

    }

}