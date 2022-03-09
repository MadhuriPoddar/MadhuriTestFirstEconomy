package com.myself.madhurifirsteconomytest.ui

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}