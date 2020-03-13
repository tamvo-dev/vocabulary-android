package com.android.data.presenter

import com.android.domain.entity.Vocabulary
import io.reactivex.Observable

interface VocabularyPresenter {

    fun getVocabularys(): Observable<List<Vocabulary>>
    fun getVocabularyById(id: Int): Observable<Vocabulary>
}