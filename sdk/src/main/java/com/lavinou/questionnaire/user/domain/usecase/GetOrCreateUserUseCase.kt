package com.lavinou.questionnaire.user.domain.usecase

import com.lavinou.questionnaire.core.result.UiResult
import com.lavinou.questionnaire.user.domain.model.User
import com.lavinou.questionnaire.user.domain.repository.UserRepository

internal class GetOrCreateUserUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): UiResult<User> {
        try {
            val user = repository.get() ?: kotlin.run {
                val newUser = repository.create()
                repository.save(user = newUser)
                return@run newUser
            }

            return UiResult.Success(user)
        } catch (e: Throwable) {
            return UiResult.Error(e)
        }
    }
}