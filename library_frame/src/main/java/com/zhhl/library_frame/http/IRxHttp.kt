package com.zhhl.library_frame.http

import io.reactivex.disposables.Disposable

interface IRxHttp {
    fun execute(checkId: Int): Disposable
}