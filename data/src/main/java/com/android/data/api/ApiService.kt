package com.android.data.api

import com.android.domain.entity.Vocabulary
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {

    @GET("/vocabularys/{id}")
    fun getVocabularyById(@Path("id") id: Int): Observable<Vocabulary>

    @GET("/vocabularys")
    fun getVocabularys(): Observable<List<Vocabulary>>
}