package com.lavinou.questionnaire.core.result

sealed interface UiResult<T> {

    class Loading<T>: UiResult<T>

    data class Success<T>(
        val data: T
    ) : UiResult<T>

    data class Error<T>(
        val throwable: Throwable,
        val uiMessage: String? = null,
    ) : UiResult<T>
}
