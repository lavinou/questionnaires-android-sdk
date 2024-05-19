package com.questionnaire.sdk.user

import com.questionnaire.sdk.user.domain.model.User
import com.questionnaire.sdk.user.domain.usecase.GetOrCreateUserUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class UserManager : KoinComponent {

    private val getOrCreateUserUseCase = inject<GetOrCreateUserUseCase>()

    suspend fun current(): User {
        return getOrCreateUserUseCase.value.invoke()
    }
}