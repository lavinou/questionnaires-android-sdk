package com.questionnaire.sdk.questionnaire.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.questionnaire.sdk.question.domain.model.QuestionStatus
import com.questionnaire.sdk.question.presentaion.action.QuestionAction
import com.questionnaire.sdk.question.presentaion.component.QuestionView
import com.questionnaire.sdk.question.presentaion.viewmodel.QuestionViewModel
import com.questionnaire.sdk.questionnaire.presentation.viewmodel.QuestionnaireViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun QuestionnaireBottomSheetDialog(
    id: String,
    onDismiss: () -> Unit
) {

    val questionViewModel: QuestionViewModel = koinViewModel()
    val questionState by questionViewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        questionViewModel.dispatch(QuestionAction.GetCurrentQuestion(
            questionnaireId = id
        ))
    })

    ModalBottomSheet(
        onDismissRequest = onDismiss) {

        Column(modifier = Modifier
            .navigationBarsPadding()
            .padding(8.dp)) {
            questionState.question?.let { question ->
                QuestionView(
                    question = question,
                    selectedAnswers = questionState.answers,
                    onAction = questionViewModel::dispatch
                )
            }

            if(questionState.status == QuestionStatus.COMPLETED) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Taker Completed Questionnaire")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = { onDismiss() }) {
                            Text(text = "Completed")
                        }
                    }
                }
            }
            else
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    questionState.previous?.let {
                        Button(onClick = {
                            questionViewModel.dispatch(QuestionAction.GetPreviousQuestion(
                                questionnaireId = id
                            ))
                        }) {
                            Text(text = "Previous")
                        }
                    } ?: kotlin.run {
                        Text(text = "")
                    }

                    Button(
                        onClick = {
                            questionViewModel.dispatch(QuestionAction.GetNextQuestion(
                                questionnaireId = id
                            ))
                        },
                        enabled = questionState.answers.isNotEmpty()
                    ) {
                        Text(text = "Next")
                    }
                }
        }
    }
}