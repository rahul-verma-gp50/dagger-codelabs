package com.example.ivyaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // make Dagger instantiate @Inject fields in LoginActivity
        (applicationContext as MyApplication).appComponent.inject(this)
        // now loginViewModel is available
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}