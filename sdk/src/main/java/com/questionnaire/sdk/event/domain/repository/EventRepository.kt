package com.questionnaire.sdk.event.domain.repository

import com.questionnaire.sdk.event.domain.model.Event

internal interface EventRepository {

    suspend fun send(event: Event)

    suspend fun supportedEvents(): List<Event>
}