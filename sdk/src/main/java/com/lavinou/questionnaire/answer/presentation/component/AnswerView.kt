package com.lavinou.questionnaire.answer.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lavinou.questionnaire.answer.domain.model.Answer

@Composable
internal fun AnswerView(answer: Answer) {

    Column {
        Text(text = answer.name)
    }

}