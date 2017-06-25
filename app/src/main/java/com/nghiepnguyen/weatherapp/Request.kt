package com.nghiepnguyen.weatherapp

import android.util.Log
import java.net.URL

/**
 * Created by W10-PRO on 24-Jun-17.
 */
class Request(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}
