package com.questionnaire.sdk

import android.content.Intent
import androidx.activity.ComponentActivity
import com.questionnaire.sdk.core.di.apiModule
import com.questionnaire.sdk.user.UserManager
import com.questionnaire.sdk.user.di.userModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.core.context.startKoin

class Questionnaire private constructor(private val builder: Builder) {

    private val userManager: UserManager
    private val scope = CoroutineScope(Dispatchers.IO)
    init {
        startKoin {
            modules(listOf(
                apiModule(apiKey = builder.apiKey),
                userModule(context = builder.activity)
            ))
        }

        userManager = UserManager()
        scope.launch {
            userManager.current()
        }

    }

    val results: Flow<QuestionnaireResult>
        get() {
            TODO()
        }

    fun send(event: QuestionnaireEvent) {

    }

    fun updateUser(user: QuestionnaireUser) {

    }


    class Builder(internal val activity: ComponentActivity, internal val apiKey: String) {

        internal var user: QuestionnaireUser = QuestionnaireUser.Anonymous
        internal var logLevel: String? = null

        fun setLogLevel(): Builder {
            return this
        }

        fun setUser(user: QuestionnaireUser): Builder {
            this.user = user
            return this
        }

        fun build(): Questionnaire {
            return Questionnaire(builder = this)
        }
    }
}