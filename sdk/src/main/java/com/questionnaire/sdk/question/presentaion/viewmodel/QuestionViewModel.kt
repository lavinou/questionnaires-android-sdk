package com.questionnaire.sdk.question.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.questionnaire.sdk.answer.domain.model.CurrentAnswer
import com.questionnaire.sdk.question.domain.model.NextQuestion
import com.questionnaire.sdk.question.domain.repository.QuestionRepository
import com.questionnaire.sdk.question.presentaion.action.QuestionAction
import com.questionnaire.sdk.question.presentaion.state.QuestionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class QuestionViewModel constructor(
    private val repository: QuestionRepository
) : ViewModel() {

    private val _state = MutableStateFlow(QuestionState())
    val state: StateFlow<QuestionState> = _state


    fun dispatch(action: QuestionAction) {
        when (action) {
            is QuestionAction.GetCurrentQuestion -> {
                viewModelScope.launch {
                    val current = repository.currentQuestion(
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

            is QuestionAction.GetNextQuestion -> {
                viewModelScope.launch {
                    val questionId = _state.value.question?.id ?: ""
                    val current = repository.nextQuestion(
                        questionnaireId = action.questionnaireId,
                        takerId = action.takerId,
                        next = NextQuestion(
                            current = questionId,
                            answers = _state.value.answers
                        )
                    )

                    _state.update {
                        it.copy(
                            question = current.question,
                            answers = emptyList(),
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
                            answers = emptyList(),
                            previous = current.previous,
                            status = current.status
                        )
                    }
                }
            }

            is QuestionAction.OnBooleanAnswerChange -> {
                _state.update {
                    it.copy(
                        answers = listOf(
                            CurrentAnswer(
                                id = action.id
                            )
                        )
                    )
                }
            }

            is QuestionAction.OnCheckBoxAnswerChange -> {
                _state.update {
                    it.copy(
                        answers = if (_state.value.answers.map { answer -> answer.id }
                                .contains(action.id)) {
                            _state.value.answers.filter { id -> id.id != action.id }
                        } else {
                            val updatedList = _state.value.answers.toMutableList()
                            updatedList.add(
                                CurrentAnswer(
                                    id = action.id
                                )
                            )
                            updatedList
                        }
                    )
                }
            }

            is QuestionAction.OnRadioAnswerChange -> {
                _state.update {
                    it.copy(
                        answers = listOf(
                            CurrentAnswer(
                                id = action.id
                            )
                        )
                    )
                }
            }

            is QuestionAction.OnSelectAnswerChange -> {

            }

            is QuestionAction.OnTextAnswerChange -> {
                _state.update {
                    it.copy(
                        answers = listOf(
                            CurrentAnswer(
                                id = action.id,
                                value = action.data
                            )
                        )
                    )
                }
            }
        }
    }

}