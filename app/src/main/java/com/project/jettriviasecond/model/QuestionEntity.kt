package com.project.jettriviasecond.model

data class QuestionEntity(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)