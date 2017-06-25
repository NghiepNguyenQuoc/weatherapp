package com.nghiepnguyen.weatherapp.domain.datasource

import com.nghiepnguyen.weatherapp.data.Forecast
import com.nghiepnguyen.weatherapp.domain.model.ForecastList

/**
 * Created by W10-PRO on 25-Jun-17.
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}