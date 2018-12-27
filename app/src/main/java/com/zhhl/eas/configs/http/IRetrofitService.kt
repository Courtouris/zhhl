package com.zhhl.eas.configs.http

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface IRetrofitService {
    @GET("/api/taxonomies")
    fun getConfigures(): Observable<Response<String>>
}