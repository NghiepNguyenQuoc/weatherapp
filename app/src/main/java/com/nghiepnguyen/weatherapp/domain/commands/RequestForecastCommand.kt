package com.nghiepnguyen.weatherapp.domain.commands

import com.nghiepnguyen.weatherapp.domain.datasource.ForecastProvider
import com.nghiepnguyen.weatherapp.domain.model.ForecastList

/**
 * Created by W10-PRO on 25-Jun-17.
 */
class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}