package com.android.vocabulary.di

import com.android.data.presenter.GetListVocabulary
import com.android.data.presenter.GetVocabularyById
import com.android.data.presenter.VocabularyPresenterImp

object Injection {
    private val getListVocabulary = GetListVocabulary()
    private val getVocabularyById = GetVocabularyById()
    val vocabularyPresenter = VocabularyPresenterImp(getListVocabulary, getVocabularyById)
}