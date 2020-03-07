package com.fizhu.allaboutui.ui

import android.os.Bundle
import android.os.Handler
import com.fizhu.allaboutui.R
import com.fizhu.allaboutui.util.AppConstants
import com.fizhu.allaboutui.util.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onInit() {
        initSplash()
    }

    private fun initSplash() {
        Handler().postDelayed({
            openMain()
        }, AppConstants.SPLASH_TIME_MILLISECOND)
    }

    private fun openMain() {
        startActivityWithFade(MainActivity::class.java)
    }
}
