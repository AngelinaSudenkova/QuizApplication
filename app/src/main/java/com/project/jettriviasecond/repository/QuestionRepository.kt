package com.project.jettriviasecond.repository

import com.project.jettriviasecond.data.DataOrException
import com.project.jettriviasecond.model.QuestionEntity
import com.project.jettriviasecond.network.QuestionApi
import java.lang.Exception
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {

    private val dataOrException = DataOrException<ArrayList<QuestionEntity>, Boolean, Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionEntity>, Boolean, Exception>{
        try{
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(!dataOrException.data.toString().isNullOrEmpty()) dataOrException.loading = false
        } catch (e: Exception){
            dataOrException.e = e
        }
        return dataOrException
    }
}