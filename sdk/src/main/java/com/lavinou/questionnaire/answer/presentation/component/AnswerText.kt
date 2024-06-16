package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lavinou.questionnaire.answer.domain.model.Answer

@Composable
internal fun AnswerText(
    answer: Answer,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(text = answer.name)
    }

}