package com.questionnaire.sdk.user.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.questionnaire.sdk.user.UserManager
import com.questionnaire.sdk.user.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class UserViewModel constructor(
    private val manager: UserManager
): ViewModel() {

    private val _state = MutableStateFlow<User?>(null)
    val state: StateFlow<User?> = _state

    init {
        viewModelScope.launch {
            val user = manager.current()
            _state.update {
                 user
            }
        }
    }

}