package com.nghiepnguyen.weatherapp.domain.datasource

import com.nghiepnguyen.weatherapp.data.Forecast
import com.nghiepnguyen.weatherapp.domain.model.ForecastList

/**
 * Created by W10-PRO on 25-Jun-17.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(
            f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }

}