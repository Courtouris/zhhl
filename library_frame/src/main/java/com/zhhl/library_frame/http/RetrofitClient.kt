package com.zhhl.library_frame.http

import com.zhhl.library_frame.config.BaseConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  retrofit http client
 */
object RetrofitClient {

    var retrofit: Retrofit? = null

    fun init(ip: String) {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(BaseConfig.TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(BaseConfig.TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(BaseConfig.TIMEOUT_SECONDS, TimeUnit.SECONDS).build()
        retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ip).client(okHttpClient).build()
    }
}