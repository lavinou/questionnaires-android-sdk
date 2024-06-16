package com.lavinou.questionnaire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.lavinou.questionnaire.questionnaire.presentation.component.QuestionnaireBottomSheetDialog
import com.lavinou.questionnaire.user.UserManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class QuestionnaireActivity : ComponentActivity() {

    private val userManager: UserManager by inject(UserManager::class.java)

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val questionnaireId = intent.getStringExtra(QuestionnaireId)

        setContent {
            MaterialTheme {
                scope.launch {
                    val user = userManager.current()
                    if (user == null) {
                        finish()
                    }
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