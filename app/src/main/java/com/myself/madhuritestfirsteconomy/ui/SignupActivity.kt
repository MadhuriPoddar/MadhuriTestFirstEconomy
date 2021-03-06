package com.myself.madhurifirsteconomytest.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.myself.madhurifirsteconomytest.ui.auth.AuthViewModel
import com.myself.madhurifirsteconomytest.ui.auth.AuthViewModelFactory
import com.myself.madhurifirsteconomytest.ui.home.HomeActivity
import com.myself.madhurifirsteconomytest.util.startHomeActivity
import com.myself.madhuritestfirsteconomy.R
import com.myself.madhuritestfirsteconomy.databinding.ActivitySignupBinding
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val binding: ActivitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
      //  progressbar.visibility = View.VISIBLE
        Intent(this, HomeActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    override fun onSuccess() {
       // progressbar.visibility = View.GONE
        startHomeActivity()
    }

    override fun onFailure(message: String) {
       // progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}