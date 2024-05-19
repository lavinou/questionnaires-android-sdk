package com.questionnaire.sdk.event.domain.model

import java.time.Instant

internal interface Event {

    val name: String

    val createdAt: Instant

    val userId: String
}