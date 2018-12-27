package com.zhhl.eas.modules.main

import android.content.Context
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.zhhl.eas.R
import com.zhhl.eas.databinding.ActivityMainBinding
import com.zhhl.library_frame.http.HttpDTO
import com.zhhl.library_frame.http.IRetrofitListener
import com.zhhl.library_frame.mvvm.ViewModelImpl

class MainViewModel(context: Context, mBinding: ActivityMainBinding) : ViewModelImpl(context, mBinding), View.OnClickListener {

    private val iMainModel by lazy { MainModel(context) }

    init {
        mBinding.onClick = this
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button ->
                iMainModel.testHttp(iRetrofitListener)
            else ->
                ToastUtils.showShort("button click")
        }
    }

    private val iRetrofitListener = object : IRetrofitListener {
        override fun onResponseSuccess(httpDTO: HttpDTO) {
        }

        override fun onResponseFailed(httpDTO: HttpDTO) {
        }

        override fun onResponseFinish(httpDTOId: Int) {
        }

        override fun onResponseError(httpDTOId: Int) {
        }
    }
}