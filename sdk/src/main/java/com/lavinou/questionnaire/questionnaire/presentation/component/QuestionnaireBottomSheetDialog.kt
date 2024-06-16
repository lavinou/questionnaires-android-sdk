package com.lavinou.questionnaire.questionnaire.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction
import com.lavinou.questionnaire.answer.presentation.viewmodel.AnswerViewModel
import com.lavinou.questionnaire.question.domain.model.QuestionStatus
import com.lavinou.questionnaire.question.presentaion.action.QuestionAction
import com.lavinou.questionnaire.question.presentaion.component.QuestionView
import com.lavinou.questionnaire.question.presentaion.viewmodel.QuestionViewModel
import com.lavinou.questionnaire.user.presentation.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun QuestionnaireBottomSheetDialog(
    id: String,
    onDismiss: () -> Unit
) {

    val questionViewModel: QuestionViewModel = koinViewModel()
    val questionState by questionViewModel.state.collectAsState()

    val userViewModel: UserViewModel = koinViewModel()
    val user by userViewModel.state.collectAsState()

    val answerViewModel: AnswerViewModel = koinViewModel()
    val answerState by answerViewModel.state.collectAsState()

    LaunchedEffect(key1 = user, block = {
        user?.let {
            questionViewModel.dispatch(
                QuestionAction.GetCurrentQuestion(
                    questionnaireId = id,
                    takerId = it.id
                )
            )
        }
    })

    ModalBottomSheet(
        modifier = Modifier,
        onDismissRequest = onDismiss
    ) {

        Column(
            modifier = Modifier
                .animateContentSize()
                .navigationBarsPadding()
                .padding(8.dp)
        ) {
            questionState.question?.let { question ->
                QuestionView(
                    question = question,
                    selectedAnswers = answerState.answers,
                    onAction = answerViewModel::dispatch
                )
            }

            if (questionState.status == QuestionStatus.COMPLETED) {
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
            } else
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    questionState.previous?.let {
                        Button(onClick = {
                            questionViewModel.dispatch(
                                QuestionAction.GetPreviousQuestion(
                                    questionnaireId = id,
                                    takerId = user?.id ?: ""
                                )
                            )
                            answerViewModel.dispatch(AnswerAction.OnClearAnswers)
                        }) {
                            Text(text = "Previous")
                        }
                    } ?: kotlin.run {
                        Text(text = "")
                    }

                    Button(
                        onClick = {
                            questionViewModel.dispatch(
                                QuestionAction.GetNextQuestion(
                                    questionnaireId = id,
                                    takerId = user?.id ?: "",
                                    answers = answerState.answers
                                )
                            )
                        },
                        enabled = answerState.answers.isNotEmpty()
                    ) {
                        Text(text = "Next")
                    }
                }
        }
    }
}