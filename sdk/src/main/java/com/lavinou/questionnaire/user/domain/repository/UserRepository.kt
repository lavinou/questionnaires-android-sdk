package com.lavinou.questionnaire.user.domain.repository

import com.lavinou.questionnaire.user.domain.model.User

internal interface UserRepository {

    suspend fun get(): User?

    suspend fun create(): User

    suspend fun clear(): Boolean

    suspend fun save(user: User): Boolean
}