package com.lavinou.questionnaire.question.domain.usecase

import android.util.Log
import com.lavinou.questionnaire.core.result.UiResult
import com.lavinou.questionnaire.question.domain.model.CurrentQuestion
import com.lavinou.questionnaire.question.domain.model.GetQuestion
import com.lavinou.questionnaire.question.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetCurrentQuestionUseCase constructor(
    private val repository: QuestionRepository
) {

    suspend operator fun invoke(get: GetQuestion): UiResult<CurrentQuestion> {
        return try {
            val current = repository.currentQuestion(
                questionnaireId = get.questionnaireId,
                takerId = get.takerId
            )
           UiResult.Success(current)

        } catch (e: Throwable) {
            Log.e("GetCurrentQuestionUseCase", "Unable to get Current Question: ${e.message}")
            UiResult.Error(e)
        }
    }
}