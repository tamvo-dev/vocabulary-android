package com.android.vocabulary.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.entity.Vocabulary
import com.android.vocabulary.di.Injection

class HomeViewModel : ViewModel() {

    private val vocabularyPresenter = Injection.vocabularyPresenter;

    private val _vocabularys = MutableLiveData<List<Vocabulary>>().apply {
        value = vocabularyPresenter.getListVocabulary(0);
    }

    val vocabulary: LiveData<List<Vocabulary>> = _vocabularys
}