package com.zhhl.library_frame.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object GsonTool {

    var gson: Gson? = null

    init {
        gson = GsonBuilder().disableHtmlEscaping().create()
    }
}

fun <T> String.toPo(): T {
    return GsonTool.gson!!.fromJson<T>(this, object : TypeToken<T>() {}.type)
}