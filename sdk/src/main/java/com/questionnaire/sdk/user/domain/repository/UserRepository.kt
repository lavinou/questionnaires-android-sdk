package com.questionnaire.sdk.user.domain.repository

import com.questionnaire.sdk.user.domain.model.User

internal interface UserRepository {

    suspend fun get(): User?

    suspend fun create(): User

    suspend fun clear(): Boolean

    suspend fun save(user: User): Boolean
}