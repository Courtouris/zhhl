package com.zhhl.library_frame.mvvm

import com.zhhl.library_frame.http.IRetrofitListener
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Response

interface IModel {
    fun executeHttp(requestId: Int, observable: Observable<Response<String>>, iRetrofitListener: IRetrofitListener)

    fun requestBody(json: String): RequestBody
}