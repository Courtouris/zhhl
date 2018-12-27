package com.zhhl.eas

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.zhhl.eas.configs.http.HttpConfig
import com.zhhl.library_frame.http.RetrofitClient

class ZHHLApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        RetrofitClient.init(HttpConfig.IP)
    }
}