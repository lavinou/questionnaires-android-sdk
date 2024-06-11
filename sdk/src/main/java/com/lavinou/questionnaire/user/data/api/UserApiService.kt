package com.lavinou.questionnaire.user.data.api

import com.lavinou.questionnaire.core.api.ApiClient
import com.lavinou.questionnaire.core.api.get
import com.lavinou.questionnaire.core.api.post
import com.lavinou.questionnaire.user.data.api.contract.UserResponse

internal class UserApiService constructor(
    private val apiClient: ApiClient
) {

    suspend fun createUser(): UserResponse {
        val result = apiClient.post<Unit, UserResponse>("users/takers/", data = Unit)
        return result.getOrThrow()
    }

    suspend fun getUser(id: String): UserResponse? {
        return apiClient.get<UserResponse>(resource = "users/takers/$id/")
            .getOrNull()
    }
}