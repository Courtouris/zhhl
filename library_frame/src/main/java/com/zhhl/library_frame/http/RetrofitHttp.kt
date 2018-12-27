package com.zhhl.library_frame.http

import com.blankj.utilcode.util.ToastUtils
import com.zhhl.library_frame.gson.toPo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class RetrofitHttp : IRxHttp {

    private var observable: Observable<Response<String>>? = null
    private var iRetrofitListener: IRetrofitListener? = null

    constructor(builder: Builder) {
        this.observable = builder.observable
        this.iRetrofitListener = builder.iRetrofitListener
    }

    override fun execute(httpDTOId: Int): Disposable {
        if (observable == null)
            throw Exception("No Observable Exception")

        return observable!!.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe({
            rxSuccess(httpDTOId, it)
        }, {
            rxError(httpDTOId)
        })
    }

    private fun rxError(httpDTOId: Int) {
        ToastUtils.showShort("请检查网络~")
        if (iRetrofitListener == null)
            return

        iRetrofitListener!!.onResponseFinish(httpDTOId)
        iRetrofitListener!!.onResponseError(httpDTOId)
    }

    private fun rxSuccess(httpDTOId: Int, it: Response<String>) {

        iRetrofitListener!!.onResponseFinish(httpDTOId)
        if (iRetrofitListener == null)
            return

        var httpDTO = HttpDTO()
        httpDTO.checkId = httpDTOId
        httpDTO.response = it.raw()
        httpDTO.content = it.body()

        if (STATUS200 == it.code())
            iRetrofitListener!!.onResponseSuccess(httpDTO)
        else {
            val errorMsg = it.errorBody()!!.string()
            var errorPo = errorMsg.toPo<ErrorPo>()

            if (errorPo == null)
                errorPo = ErrorPo()
            errorPo.statusCode = it.code()

            httpDTO.errorPo = errorPo
            iRetrofitListener!!.onResponseFailed(httpDTO)
        }
    }

    class Builder {
        var observable: Observable<Response<String>>? = null
        var iRetrofitListener: IRetrofitListener? = null

        fun observable(observable: Observable<Response<String>>?): Builder {
            this.observable = observable
            return this
        }

        fun iRetrofitListener(iRetrofitListener: IRetrofitListener?): Builder {
            this.iRetrofitListener = iRetrofitListener
            return this
        }

        fun build(): RetrofitHttp {
            return RetrofitHttp(this)
        }
    }
}