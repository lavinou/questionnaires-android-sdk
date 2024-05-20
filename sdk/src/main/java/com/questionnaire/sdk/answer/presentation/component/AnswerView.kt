package com.questionnaire.sdk.answer.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.questionnaire.sdk.answer.domain.model.Answer

@Composable
internal fun AnswerView(answer: Answer) {

    Column {
        Text(text = answer.name)
    }

}