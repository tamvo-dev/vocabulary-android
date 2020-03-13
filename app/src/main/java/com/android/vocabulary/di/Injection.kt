package com.android.vocabulary.di

import com.android.data.api.ApiService
import com.android.data.presenter.VocabularyPresenterImp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private val BASE_URL = "http://localhost:8080"

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    val vocabularyPresenter = VocabularyPresenterImp(apiService)


}