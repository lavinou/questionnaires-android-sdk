package com.questionnaire.sdk.event.data.repository

import com.questionnaire.sdk.event.domain.model.Event
import com.questionnaire.sdk.event.domain.repository.EventRepository

internal class DefaultEventRepository : EventRepository {

    override suspend fun send(event: Event) {

    }

    override suspend fun supportedEvents(): List<Event> {
        return emptyList()
    }
}