package com.zhhl.library_frame.archs

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

interface ILifecycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun ON_CREATE()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun ON_START()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun ON_RESUME()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun ON_PAUSE()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun ON_STOP()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun ON_DESTROY()
}