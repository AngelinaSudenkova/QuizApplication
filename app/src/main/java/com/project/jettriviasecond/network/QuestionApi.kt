package com.project.jettriviasecond.network

import com.project.jettriviasecond.model.QuestionList
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): QuestionList
}