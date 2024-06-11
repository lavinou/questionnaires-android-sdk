package com.lavinou.questionnaire.core.di

import com.lavinou.questionnaire.core.api.ApiClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal fun apiModule(apiKey: String) = module {

    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }

        }
    }

    single { ApiClient(client = get(), apiKey = apiKey) }
}