package com.questionnaire.sdk.user.data.api

import com.questionnaire.sdk.core.api.ApiClient
import com.questionnaire.sdk.core.api.get
import com.questionnaire.sdk.core.api.post
import com.questionnaire.sdk.user.data.api.contract.UserResponse

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