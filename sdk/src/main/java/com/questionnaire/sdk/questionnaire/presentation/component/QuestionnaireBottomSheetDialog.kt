package com.questionnaire.sdk.questionnaire.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun QuestionnaireBottomSheetDialog() {
    ModalBottomSheet(onDismissRequest = {

    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Button(onClick = { /*TODO*/ }) {
                Text(text = "Previous")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Next")
            }
        }
    }
}