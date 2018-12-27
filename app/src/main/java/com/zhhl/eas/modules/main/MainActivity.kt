package com.zhhl.eas.modules.main

import com.zhhl.eas.R
import com.zhhl.eas.databinding.ActivityMainBinding
import com.zhhl.library_frame.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getViewModel() = MainViewModel(this, mBinding!!)

    override fun getBindingLayout(): Int = R.layout.activity_main
}