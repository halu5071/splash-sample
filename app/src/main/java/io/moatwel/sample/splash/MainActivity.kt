package io.moatwel.sample.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private var appReady = false

    companion object {
        private const val DELAY_MILLI_SEC = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepVisibleCondition { appReady.not() }
        }

        Handler(mainLooper).postDelayed({ appReady = true }, DELAY_MILLI_SEC)

        setContentView(R.layout.activity_main)
    }
}