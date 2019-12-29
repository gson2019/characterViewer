package com.example.characterviewer.api

import okhttp3.Interceptor
import okhttp3.Response

class CharacterInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
        return chain.proceed(newRequest.build())
    }
}