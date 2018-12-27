package com.zhhl.library_frame.http

interface IRetrofitListener {
    fun onResponseSuccess(httpDTO: HttpDTO)

    fun onResponseFailed(httpDTO: HttpDTO)

    fun onResponseFinish(httpDTOId: Int)

    fun onResponseError(httpDTOId: Int)
}