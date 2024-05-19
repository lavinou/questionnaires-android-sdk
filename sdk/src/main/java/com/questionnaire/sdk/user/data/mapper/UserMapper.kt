package com.questionnaire.sdk.user.data.mapper

import com.questionnaire.sdk.user.data.api.contract.UserResponse
import com.questionnaire.sdk.user.domain.model.User

internal fun UserResponse.toUser(): User {
    return User(
        id = id,
        email = email
    )
}