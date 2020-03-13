package com.android.data.presenter

import com.android.domain.entity.Vocabulary

interface VocabularyPresenter {

    fun getListVocabulary(start: Int): List<Vocabulary>
    fun getVocabularyById(id: Int): Vocabulary
}