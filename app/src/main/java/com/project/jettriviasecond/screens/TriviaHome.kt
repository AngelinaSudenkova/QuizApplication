package com.project.jettriviasecond.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


import com.project.jettriviasecond.components.Questions

@Composable
fun TriviaHome( viewModel: QuestionViewModel = hiltViewModel()) {
    Questions(viewModel = viewModel)
}