package com.lavinou.questionnaire.user.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.lavinou.questionnaire.user.data.api.UserApiService
import com.lavinou.questionnaire.user.data.mapper.toUser
import com.lavinou.questionnaire.user.domain.model.User
import com.lavinou.questionnaire.user.domain.repository.UserRepository

internal class DefaultUserRepository constructor(
    private val service: UserApiService,
    context: Context
) : UserRepository {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        USER_PREF, Context.MODE_PRIVATE
    )
    private var inMemoryUser: User? = null

    override suspend fun get(): User? {

        val id = preferences.getString(TAKER_ID, null) ?: return null

        if (id == inMemoryUser?.id)
            return inMemoryUser

        val user = service.getUser(id = id)?.toUser()
        inMemoryUser = user

        return user
    }

    override suspend fun clear(): Boolean {
        preferences.edit {
            putString(TAKER_ID, null)
        }
        inMemoryUser = null

        return true
    }

    override suspend fun create(): User {
        val user = service.createUser().toUser()

        preferences.edit {
            putString(TAKER_ID, user.id)
        }

        inMemoryUser = user

        return user
    }

    override suspend fun save(user: User): Boolean {
        return false
    }

    companion object {

        const val USER_PREF = "USER_PREF"
        const val TAKER_ID = "TAKER_ID"
    }
}