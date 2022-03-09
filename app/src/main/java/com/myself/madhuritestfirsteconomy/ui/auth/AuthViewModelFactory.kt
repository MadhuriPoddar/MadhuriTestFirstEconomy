package com.myself.madhurifirsteconomytest.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.MaybeSource
import io.reactivex.functions.Function
import org.reactivestreams.Publisher

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    private val repository: Function<MaybeSource<Any>, Publisher<Any>>
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }

}
