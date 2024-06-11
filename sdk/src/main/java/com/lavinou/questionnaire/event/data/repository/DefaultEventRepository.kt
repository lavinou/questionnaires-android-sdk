package com.lavinou.questionnaire.event.data.repository

import com.lavinou.questionnaire.event.domain.model.Event
import com.lavinou.questionnaire.event.domain.repository.EventRepository

internal class DefaultEventRepository : EventRepository {

    override suspend fun send(event: Event) {

    }

    override suspend fun supportedEvents(): List<Event> {
        return emptyList()
    }
}