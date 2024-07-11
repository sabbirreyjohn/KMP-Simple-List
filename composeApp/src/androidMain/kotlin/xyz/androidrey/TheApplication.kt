package xyz.androidrey

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

class TheApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@TheApplication)
        }
    }

}