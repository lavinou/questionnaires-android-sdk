package com.questionnaire.sdk

import java.util.UUID

data class QuestionnaireUser(
    val id: String,
    val email: String? = null,
    val phone: String? = null,
    val properties: Map<String, String> = emptyMap()
) {

    companion object {

        val Anonymous: QuestionnaireUser
            get() {

                return QuestionnaireUser(
                    id = UUID.randomUUID().toString(),
                    properties = mapOf(
                        "DeviceId" to "",
                        "SystemVersion" to "",
                    )
                )
            }
    }
}
