package com.lavinou.questionnaire.user

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

    suspend fun current(): User {
        val user = getOrCreateUserUseCase.invoke()
        _state.update {
            user
        }
        return user
    }

}