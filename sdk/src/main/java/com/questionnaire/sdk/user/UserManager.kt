package com.questionnaire.sdk.user

import com.questionnaire.sdk.user.domain.model.User
import com.questionnaire.sdk.user.domain.usecase.GetOrCreateUserUseCase

internal class UserManager constructor(
    private val getOrCreateUserUseCase: GetOrCreateUserUseCase
) {


    suspend fun current(): User {
        return getOrCreateUserUseCase.invoke()
    }
}