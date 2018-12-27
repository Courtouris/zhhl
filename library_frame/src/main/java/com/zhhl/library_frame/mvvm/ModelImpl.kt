package com.zhhl.library_frame.mvvm

import android.content.Context
import com.zhhl.library_frame.base.BaseActivity
import com.zhhl.library_frame.http.IRetrofitListener
import com.zhhl.library_frame.http.RetrofitHttp
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Response
import java.lang.Exception

open class ModelImpl(context: Context) : IModel {

    private var activity: BaseActivity<*, *>? = null

    init {
        if (context is BaseActivity<*, *>)
            activity = context
        else try {
            throw Exception("context not baseactivity exception")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun executeHttp(requestId: Int, observable: Observable<Response<String>>, iRetrofitListener: IRetrofitListener) {
        val iRxHttp = RetrofitHttp.Builder().observable(observable).iRetrofitListener(iRetrofitListener).build()
        activity?.compositeDisposable?.add(iRxHttp.execute(requestId))
    }

    override fun requestBody(json: String): RequestBody {
        return RequestBody.create(MediaType.parse("application/json"), json)
    }
}