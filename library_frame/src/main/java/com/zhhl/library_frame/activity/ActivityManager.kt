package com.zhhl.library_frame.activity

import android.app.Activity

object ActivityManager : IActivityManager {

    private var activities = ArrayList<Activity>()

    override fun add(activity: Activity) {
        activities.add(activity)
    }

    override fun remove(activity: Activity) {
        activities.remove(activity)
    }

    override fun getActivitiesByClassName(clazz: Class<Activity>): List<Activity> {
        var activities = ArrayList<Activity>()

        this.activities.forEach {
            if (it.javaClass == clazz)
                activities.add(it)
        }
        return activities
    }

    override fun getActivityByClassName(clazz: Class<Activity>): Activity? {
        var activities = this.getActivitiesByClassName(clazz)
        return if (activities.isNotEmpty()) activities[0] else null
    }

    override fun finishAll() {
        activities.forEach {
            it.finish()
        }
        activities.clear()
        System.gc()
    }

    override fun getAll(): List<Activity> {
        return activities
    }

    override fun getLastest(): Activity? {
        return if (activities.isNotEmpty()) activities[0] else null
    }

    override fun isTheLastest(activity: Activity): Boolean {
        var lactivity = this.getLastest()
        return activity == lactivity
    }

    override fun clearComplexOfThis(clazz: Class<Activity>) {
        var activities = getActivitiesByClassName(clazz)
        if (activities.size > 1)
            (0 until activities.size - 1).forEach {
                activities[it].finish()
            }
    }

    override fun finishWithout(clazz: Class<Activity>) {
        activities.forEach {
            if (it.javaClass != clazz)
                it.finish()
        }
    }
}