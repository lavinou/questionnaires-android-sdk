package com.questionnaire.sdk.core.api

import android.os.Build
import com.questionnaire.sdk.BuildConfig
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
import io.ktor.util.InternalAPI
import java.net.URL

internal open class ApiClient constructor(
    internal val client: HttpClient,
    internal val apiKey: String
) {

    open val baseUrl: String
        get() = "https://questionnaire-api.lavinou.com/v1"

    open val defaultPathParams: Map<String, String>
        get() = emptyMap()

    open val defaultHeaders: Map<String, String>
        get() = mapOf(
            "User-Agent" to "questai-sdk/(${BuildConfig.SDK_VERSION}) (Android; ${Build.MANUFACTURER} ${Build.VERSION.RELEASE}; ${Build.MODEL})"
        )

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

@OptIn(InternalAPI::class)
internal suspend inline fun <reified Response> ApiClient.get(
    resource: String,
    queryParams: Map<String, String> = emptyMap()
): Result<Response> {

    val response = client.get {
        setUrl(resource, queryParams)
        headers {
            header("Authorization", "$tokenName $apiKey")
            defaultHeaders.map {
                header(it.key, it.value)
            }
        }
        contentType(ContentType.Application.Json)

    }

    if (response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.post(
    resource: String,
    data: Request,
    queryParams: Map<String, String> = emptyMap()
): Result<Response> {

    val response = client.post {
        setUrl(resource, queryParams)
        headers {
            header("Authorization", "$tokenName $apiKey")
            defaultHeaders.map {
                header(it.key, it.value)
            }
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if (response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.put(
    resource: String,
    data: Request
): Result<Response> {

    val response = client.put {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
            defaultHeaders.map {
                header(it.key, it.value)
            }
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if (response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.patch(
    resource: String,
    data: Request
): Result<Response> {

    val response = client.patch {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
            defaultHeaders.map {
                header(it.key, it.value)
            }
        }
        setBody(data)
        contentType(ContentType.Application.Json)
    }

    if (response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}

internal suspend inline fun <reified Request, reified Response> ApiClient.delete(
    resource: String,
    data: Request? = null
): Result<Response> {

    val response = client.delete {
        setUrl(resource)
        headers {
            header("Authorization", "$tokenName $apiKey")
            defaultHeaders.map {
                header(it.key, it.value)
            }
        }
        data?.let {
            setBody(data)
        }
        contentType(ContentType.Application.Json)
    }

    if (response.status.value >= 400) {
        return Result.failure(Exception(""))
    }

    return Result.success(response.body())
}