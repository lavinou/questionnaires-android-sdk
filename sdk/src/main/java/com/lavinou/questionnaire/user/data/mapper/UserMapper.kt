package com.lavinou.questionnaire.user.data.mapper

import com.lavinou.questionnaire.user.data.api.contract.UserResponse
import com.lavinou.questionnaire.user.domain.model.User

internal fun UserResponse.toUser(): User {
    return User(
        id = id,
        email = email
    )
}