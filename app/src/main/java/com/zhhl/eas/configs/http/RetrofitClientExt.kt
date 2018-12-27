package com.zhhl.eas.configs.http

import com.zhhl.library_frame.http.RetrofitClient

fun RetrofitClient.retrofitApi(): IRetrofitService {
    return this.retrofit?.create(IRetrofitService::class.java)!!
}