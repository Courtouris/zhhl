package com.zhhl.library_frame.activity

import android.app.Activity

interface IActivityManager {
    fun add(activity: Activity)

    fun remove(activity: Activity)

    fun getActivitiesByClassName(clazz: Class<Activity>): List<Activity>

    fun getActivityByClassName(clazz: Class<Activity>): Activity?

    fun finishAll()

    fun getAll(): List<Activity>

    fun getLastest(): Activity?

    fun isTheLastest(activity: Activity): Boolean

    fun clearComplexOfThis(clazz: Class<Activity>)

    fun finishWithout(clazz: Class<Activity>)
}