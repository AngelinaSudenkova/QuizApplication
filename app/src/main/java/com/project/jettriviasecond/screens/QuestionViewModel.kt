package com.project.jettriviasecond.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.jettriviasecond.data.DataOrException
import com.project.jettriviasecond.model.QuestionEntity
import com.project.jettriviasecond.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {

    private val _data: MutableState<DataOrException<ArrayList<QuestionEntity>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    val data = _data

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            _data.value.loading = true
            _data.value = repository.getAllQuestions()
            if (!_data.value.data.isNullOrEmpty()) {
                _data.value.loading = false
            }
        }
    }
    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}