package com.lavinou.questionnaire.event.domain.model

import java.time.Instant

internal interface Event {

    val name: String

    val createdAt: Instant

    val userId: String
}