package com.questionnaire.sdk.user.domain.usecase

import com.questionnaire.sdk.user.domain.model.User
import com.questionnaire.sdk.user.domain.repository.UserRepository

internal class GetOrCreateUserUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): User {
        val user = repository.get() ?: kotlin.run {
            val newUser = repository.create()
            repository.save(user = newUser)
            return@run newUser
        }

        return user
    }
}