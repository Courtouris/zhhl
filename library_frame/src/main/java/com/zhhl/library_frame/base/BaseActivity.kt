package com.zhhl.library_frame.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhhl.library_frame.activity.ActivityManager
import com.zhhl.library_frame.mvvm.IViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<D : ViewDataBinding?, B : IViewModel> : AppCompatActivity() {

    var mBinding: D? = null
    var mViewModel: B? = null

    var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvvmInit()
        ActivityManager.add(this)
    }

    //实例化viewdatabinding  viewmodel
    private fun mvvmInit() {
        mBinding = DataBindingUtil.setContentView<D>(this, getBindingLayout())
        mViewModel = getViewModel()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
        ActivityManager.remove(this)
    }

    //具体activity去实例化viewmodel
    abstract fun getViewModel(): B

    //设置布局文件
    abstract fun getBindingLayout(): Int
}