package com.lavinou.questionnaire

import android.content.Intent
import androidx.activity.ComponentActivity
import com.lavinou.questionnaire.answer.di.answerModule
import com.lavinou.questionnaire.core.di.apiModule
import com.lavinou.questionnaire.question.di.questionModule
import com.lavinou.questionnaire.questionnaire.di.questionnaireModule
import com.lavinou.questionnaire.user.di.userModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import org.koin.core.context.startKoin

class Questionnaire private constructor(private val builder: Builder) {

    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        startKoin {
            modules(
                listOf(
                    apiModule(apiKey = builder.apiKey),
                    userModule(context = builder.activity),
                    questionnaireModule(),
                    questionModule(),
                    answerModule()
                )
            )
        }
    }

    fun launch(id: String) {
        val intent = Intent(builder.activity, QuestionnaireActivity::class.java)
        intent.putExtra(QuestionnaireActivity.QuestionnaireId, id)
        builder.activity.startActivity(intent)
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