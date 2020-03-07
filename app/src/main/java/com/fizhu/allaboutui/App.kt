package com.fizhu.allaboutui

import android.app.Application

/**
 * Created by fizhu on 07,March,2020
 * Hvyz.anbiya@gmail.com
 */

class App : Application() {

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: App
    }

}