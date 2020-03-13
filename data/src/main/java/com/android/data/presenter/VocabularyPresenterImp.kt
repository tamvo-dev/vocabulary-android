package com.android.data.presenter

import com.android.data.api.ApiService
import com.android.domain.entity.Vocabulary
import io.reactivex.Observable

class VocabularyPresenterImp(val apiService: ApiService) : VocabularyPresenter {

    override fun getVocabularys(): Observable<List<Vocabulary>> {
        return apiService.getVocabularys()
    }

    override fun getVocabularyById(id: Int): Observable<Vocabulary> {
        return apiService.getVocabularyById(id)
    }

}