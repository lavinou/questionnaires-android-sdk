package com.questionnaire.sdk.core.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import java.net.URL

internal open class ApiClient constructor(
    internal val client: HttpClient,
    internal val apiKey: String
) {

    open val baseUrl: String
        get() = "http://192.168.4.24:8000/v1"

    open val defaultPathParams: Map<String, String>
        get() = emptyMap()

    open val tokenName: String
        get() = "Api-Key"


    fun HttpRequestBuilder.setUrl(resource: String, queryParams: Map<String, String> = emptyMap()) {
        url {
            url(URL("$baseUrl/$resource"))
            defaultPathParams.map {
                parameters.append(it.key, it.value)
            }
            queryParams.map {
                parameters.append(it.key, it.value)
            }
        }
    }
}

internal suspend inline fun <reified Response> ApiClient.get(resource: String, queryParams: Map<String, String> = emptyMap()): Result<Response> {

    val response = client.get {
        setUrl(resource, queryParams)
        headers {
            header("Authorization", "$tokenName $apiKey")
        }
        contentType(ContentType.Application.Json)

    }

    if(response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.post(resource: String, data: Request): Result<Response> {

    val response = client.post {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if(response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.put(resource: String, data: Request): Result<Response> {

    val response = client.put {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if(response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.patch(resource: String, data: Request): Result<Response> {

    val response = client.patch {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if(response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.delete(resource: String, data: Request? = null): Result<Response> {

    val response = client.delete {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
        }
        data?.let {
            setBody(data)
        }
        contentType(ContentType.Application.Json)
    }

    if(response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}