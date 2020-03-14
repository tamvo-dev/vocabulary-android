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

    companion object {
        val TAG = "HomeViewModel"
    }

    private val vocabularyPresenter = Injection.vocabularyPresenter
    private var disposable: Disposable? = null

    private val _vocabularys = MutableLiveData<List<Vocabulary>>().apply {
        value = mutableListOf()
    }
    val vocabulary: LiveData<List<Vocabulary>> = _vocabularys
    var position = 0

    init {
        getVocabularys()
    }


    fun getVocabularys() {

        disposable = vocabularyPresenter.getVocabularys()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {_vocabularys.value = it},
                {Log.e(TAG, it.toString())},
                { Log.i(TAG, "Success")}
            )
    }


    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }
}