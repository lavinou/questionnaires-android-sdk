package com.questionnaire.sdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.questionnaire.sdk.questionnaire.presentation.component.QuestionnaireBottomSheetDialog
import com.questionnaire.sdk.user.UserManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class QuestionnaireActivity: ComponentActivity() {

    private val userManager: UserManager by inject(UserManager::class.java)

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questionnaireId = intent.getStringExtra(QuestionnaireId)



        setContent {
            MaterialTheme {
                scope.launch {
                    userManager.current()
                }
                questionnaireId?.let {
                    QuestionnaireBottomSheetDialog(
                        id = questionnaireId,
                        onDismiss = {
                            finish()
                        }
                    )
                } ?: finish()
            }
        }
    }

    internal companion object {

        const val QuestionnaireId = "questionnaireId"
    }
}