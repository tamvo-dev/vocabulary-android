package com.android.data.presenter

import com.android.domain.entity.Vocabulary

class VocabularyPresenterImp(val getListVocabularyImp: GetListVocabulary,
                             val getVocabularyByIdImp: GetVocabularyById) : VocabularyPresenter {

    override fun getListVocabulary(start: Int): List<Vocabulary> {
        return getListVocabularyImp.execute(start)
    }

    override fun getVocabularyById(id: Int): Vocabulary {
        return getVocabularyByIdImp.execute(id)
    }

}