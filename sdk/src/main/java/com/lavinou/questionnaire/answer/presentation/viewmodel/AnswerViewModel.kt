package com.lavinou.questionnaire.answer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.lavinou.questionnaire.answer.domain.model.CurrentAnswer
import com.lavinou.questionnaire.answer.presentation.action.AnswerAction
import com.lavinou.questionnaire.answer.presentation.state.AnswerState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class AnswerViewModel : ViewModel() {

    private val _state = MutableStateFlow(AnswerState())
    val state: StateFlow<AnswerState> = _state

    fun dispatch(action: AnswerAction) {
        when (action) {

            is AnswerAction.OnBooleanAnswerChange -> {
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

            is AnswerAction.OnCheckBoxAnswerChange -> {
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

            is AnswerAction.OnRadioAnswerChange -> {
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

            is AnswerAction.OnSelectAnswerChange -> {

            }

            is AnswerAction.OnTextAnswerChange -> {
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

            is AnswerAction.OnClearAnswers -> {
                _state.update {
                    it.copy(
                        answers = emptyList()
                    )
                }
            }
        }
    }
}