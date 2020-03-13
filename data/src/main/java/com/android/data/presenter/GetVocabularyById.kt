package com.android.data.presenter

import com.android.domain.entity.Vocabulary

class GetVocabularyById {
    fun execute(id: Int): Vocabulary {
        return Vocabulary(1, "hello", "xin chao")
    }
}