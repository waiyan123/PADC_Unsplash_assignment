package com.waiyanphyo.mykotlin.utils

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor{

    private val clientId : String

    constructor(clientId : String){
        this.clientId = clientId
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().addHeader("Authorization","Client-ID"+clientId)
            .build()
        return chain.proceed(request)
    }
}