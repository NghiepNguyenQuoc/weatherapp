package com.nghiepnguyen.weatherapp.domain.commands

/**
 * Created by W10-PRO on 25-Jun-17.
 */
interface Command<out T> {
    fun execute(): T
}
