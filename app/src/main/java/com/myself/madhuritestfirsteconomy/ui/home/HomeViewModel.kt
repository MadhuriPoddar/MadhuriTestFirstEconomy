package com.myself.madhurifirsteconomytest.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.myself.madhurifirsteconomytest.data.UserRepository
import com.myself.madhurifirsteconomytest.util.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user = repository.currentUser()

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}