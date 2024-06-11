package com.lavinou.questionnaire.event.domain.repository

import com.lavinou.questionnaire.event.domain.model.Event

internal interface EventRepository {

    suspend fun send(event: Event)

    suspend fun supportedEvents(): List<Event>
}