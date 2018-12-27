package com.zhhl.eas.modules.main

import android.content.Context
import com.zhhl.eas.configs.http.TEST
import com.zhhl.eas.configs.http.retrofitApi
import com.zhhl.library_frame.http.IRetrofitListener
import com.zhhl.library_frame.http.RetrofitClient
import com.zhhl.library_frame.mvvm.ModelImpl

class MainModel(context: Context) : ModelImpl(context), IMainModel {
    override fun testHttp(iRetrofitListener: IRetrofitListener) {
        executeHttp(TEST, RetrofitClient.retrofitApi().getConfigures(), iRetrofitListener)
    }
}