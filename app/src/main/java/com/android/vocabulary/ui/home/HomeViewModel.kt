package com.android.vocabulary.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.entity.Vocabulary
import com.android.vocabulary.di.Injection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    private val vocabularyPresenter = Injection.vocabularyPresenter
    private var disposable: Disposable? = null

    init {
        Log.e("HOME", "Init")
        getVocabularys()
    }

    private val _vocabularys = MutableLiveData<List<Vocabulary>>().apply {
        value = mutableListOf()
    }

    fun getVocabularys() {

        disposable = vocabularyPresenter.getVocabularyById(15)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {Log.e("HOME", it.toString())},
                {error -> Log.e("HOME", error.toString())},
                { Log.e("HOME", "Success")}
            )
    }

    val vocabulary: LiveData<List<Vocabulary>> = _vocabularys

    override fun onCleared() {
        super.onCleared()
        Log.e("HOME", "Disposable")
        disposable?.dispose()
        disposable = null
    }
}