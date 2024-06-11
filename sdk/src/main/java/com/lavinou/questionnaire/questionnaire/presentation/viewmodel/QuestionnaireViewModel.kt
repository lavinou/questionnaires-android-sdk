package com.lavinou.questionnaire.questionnaire.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.lavinou.questionnaire.questionnaire.domain.repository.QuestionnaireRepository


internal class QuestionnaireViewModel constructor(
    private val repository: QuestionnaireRepository
) : ViewModel() {


}