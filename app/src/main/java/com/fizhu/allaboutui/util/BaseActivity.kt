package com.fizhu.allaboutui.util

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.transition.Fade
import android.transition.Visibility
import androidx.appcompat.app.AppCompatActivity
import com.fizhu.allaboutui.R

/**
 * Created by fizhu on 07,March,2020
 * Hvyz.anbiya@gmail.com
 */
abstract class BaseActivity: AppCompatActivity() {

    private val TAG = "BaseActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun startActivityWithFade(clazz: Class<*>) {
        startActivity(clazz)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun startActivityWithFade(clazz: Class<*>, bundle: Bundle) {
        startActivity(clazz, bundle)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun startActivityFromRight(clazz: Class<*>, bundle: Bundle) {
        startActivity(clazz, bundle)
        overridePendingTransition(R.anim.anim_enter_right, R.anim.anim_sticky)
    }

    fun startActivityFromRight(clazz: Class<*>) {
        startActivity(clazz)
        overridePendingTransition(R.anim.anim_enter_right, R.anim.anim_sticky)
    }

    fun startActivityFromBottom(clazz: Class<*>) {
        startActivity(clazz)
        overridePendingTransition(R.anim.anim_enter_bottom, R.anim.anim_sticky)
    }

    fun startActivity(clazz: Class<*>, bundle: Bundle?) {
        val intent = Intent(this, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    fun startActivity(clazz: Class<*>) {
        startActivity(clazz, null)
    }

    fun finishToRight() {
        finish()
        overridePendingTransition(R.anim.anim_sticky, R.anim.anim_leave_right)
    }

    fun finishWithFade() {
        finish()
        overridePendingTransition(android.R.anim.fade_out, R.anim.anim_leave_right)
    }

    private fun transitionWithFadeIn(): Fade? {
        if (Build.VERSION.SDK_INT > 20) {
            val fadeIn = Fade()
            fadeIn.duration = 500
            fadeIn.mode = Visibility.MODE_IN
            return fadeIn
        } else
            return null
    }

    private fun transitionWithFadeOut(): Fade? {
        if (Build.VERSION.SDK_INT > 20) {
            val fadeOut = Fade()
            fadeOut.duration = 300
            fadeOut.mode = Visibility.MODE_OUT
            return fadeOut
        } else
            return null
    }

    protected abstract fun onInit()
}