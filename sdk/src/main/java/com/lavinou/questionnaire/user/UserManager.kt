package com.lavinou.questionnaire.user

import com.lavinou.questionnaire.core.result.UiResult
import com.lavinou.questionnaire.user.domain.model.User
import com.lavinou.questionnaire.user.domain.usecase.GetOrCreateUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class UserManager constructor(
    private val getOrCreateUserUseCase: GetOrCreateUserUseCase
) {

    private val _state = MutableStateFlow<User?>(null)
    val state: StateFlow<User?> = _state

    suspend fun current(): User? {
        val result = getOrCreateUserUseCase.invoke()
        return when(result) {
            is UiResult.Success -> {
                _state.update {
                    result.data
                }
                result.data
            }
            else -> null
        }
    }

}