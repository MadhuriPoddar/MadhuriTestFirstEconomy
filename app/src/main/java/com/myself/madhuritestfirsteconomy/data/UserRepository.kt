package com.myself.madhurifirsteconomytest.data

import io.reactivex.MaybeSource
import io.reactivex.functions.Function
import org.kodein.di.KodeinProperty
import org.reactivestreams.Publisher

class UserRepository(
    private val firebase: FirebaseSource
){
    fun login(email: String, password: String) = firebase.login(email, password)

    fun register(email: String, password: String) = firebase.register(email, password)

    fun currentUser() = firebase.currentUser()

    fun logout() = firebase.logout()
}