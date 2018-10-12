package com.edandaniel.persistence

import com.facebook.stetho.Stetho
import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }
}