package com.lavinou.questionnaire.user.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lavinou.questionnaire.user.UserManager
import com.lavinou.questionnaire.user.domain.model.User
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class UserViewModel constructor(
    private val manager: UserManager
) : ViewModel() {

    val state: StateFlow<User?> = manager.state

    init {
        viewModelScope.launch {
            val user = manager.current()
        }
    }

}