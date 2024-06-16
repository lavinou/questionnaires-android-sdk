package com.lavinou.questionnaire.question.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer
import com.lavinou.questionnaire.core.result.UiResult
import com.lavinou.questionnaire.question.domain.model.GetQuestion
import com.lavinou.questionnaire.question.domain.model.NextQuestion
import com.lavinou.questionnaire.question.domain.repository.QuestionRepository
import com.lavinou.questionnaire.question.domain.usecase.GetCurrentQuestionUseCase
import com.lavinou.questionnaire.question.presentaion.action.QuestionAction
import com.lavinou.questionnaire.question.presentaion.state.QuestionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class QuestionViewModel constructor(
    private val repository: QuestionRepository,
    private val getCurrentQuestionUseCase: GetCurrentQuestionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(QuestionState())
    val state: StateFlow<QuestionState> = _state


    fun dispatch(action: QuestionAction) {
        when (action) {
            is QuestionAction.GetCurrentQuestion -> {
                viewModelScope.launch {
                    updateCurrentQuestion(action)
                }
            }

            is QuestionAction.GetNextQuestion -> {
                viewModelScope.launch {
                    val questionId = _state.value.question?.id ?: ""
                    val current = repository.nextQuestion(
                        questionnaireId = action.questionnaireId,
                        takerId = action.takerId,
                        next = NextQuestion(
                            current = questionId,
                            answers = action.answers
                        )
                    )

                    _state.update {
                        it.copy(
                            question = current.question,
                            previous = current.previous,
                            status = current.status
                        )
                    }
                }
            }

            is QuestionAction.GetPreviousQuestion -> {
                viewModelScope.launch {
                    val current = repository.previousQuestion(
                        questionnaireId = action.questionnaireId,
                        takerId = action.takerId
                    )

                    _state.update {
                        it.copy(
                            question = current.question,
                            previous = current.previous,
                            status = current.status
                        )
                    }
                }
            }
        }
    }

    private suspend fun updateCurrentQuestion(action: QuestionAction.GetCurrentQuestion) {
        _state.update {
            it.copy(
                loading = true
            )
        }
        val result = getCurrentQuestionUseCase.invoke(
            get = GetQuestion(
                questionnaireId = action.questionnaireId,
                takerId = action.takerId
            )
        )
        when (result) {
            is UiResult.Loading -> Unit
            is UiResult.Success -> {
                val data = result.data
                _state.update {
                    it.copy(
                        question = data.question,
                        previous = data.previous,
                        status = data.status,
                        loading = false
                    )
                }
            }

            is UiResult.Error -> {
                _state.update {
                    it.copy(
                        loading = false,
                        errorMessage = result.uiMessage
                    )
                }
            }
        }
    }

}