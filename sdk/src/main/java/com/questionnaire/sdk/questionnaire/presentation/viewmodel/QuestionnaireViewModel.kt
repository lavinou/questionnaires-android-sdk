package com.questionnaire.sdk.questionnaire.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.questionnaire.sdk.questionnaire.domain.repository.QuestionnaireRepository


internal class QuestionnaireViewModel constructor(
    private val repository: QuestionnaireRepository
) : ViewModel() {


}