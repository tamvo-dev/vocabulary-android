package com.android.data.presenter

import com.android.domain.entity.Vocabulary

class GetListVocabulary {

    fun execute(start: Int): List<Vocabulary> {
        val result = mutableListOf<Vocabulary>()
        result.add(Vocabulary(1, "hello", "xin chao"))
        result.add(Vocabulary(2, "bye", "tam biet"))
        return result
    }
}