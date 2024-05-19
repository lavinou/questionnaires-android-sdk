package com.questionnaire.sdk.user.data.repository

import com.questionnaire.sdk.user.data.api.UserApiService
import com.questionnaire.sdk.user.data.mapper.toUser
import com.questionnaire.sdk.user.domain.model.User
import com.questionnaire.sdk.user.domain.repository.UserRepository

internal class DefaultUserRepository constructor(
    private val service: UserApiService
): UserRepository {

    override suspend fun get(): User? {

        return null
    }

    override suspend fun clear(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun create(): User {
        return service.createUser().toUser()
    }

    override suspend fun save(user: User): Boolean {
        return false
    }
}