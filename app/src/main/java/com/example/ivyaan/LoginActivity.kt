package com.example.ivyaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    // Reference to the Login graph
    // Notice that the variable loginComponent is not annotated with @Inject because you're not expecting
    // that variable to be provided by Dagger.

    // NOTE: LoginComponent is created in the activity's onCreate() method,
    // and it'll get implicitly destroyed when the activity gets destroyed.
    lateinit var loginComponent: LoginComponent

    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // make Dagger instantiate @Inject fields in LoginActivity
        //(applicationContext as MyApplication).appComponent.inject(this) // --> this is what injects above loginViewModel right now

        // creation of login graph using the application graph
        loginComponent = (applicationContext as MyApplication).appComponent.loginComponent().create()
        loginComponent.inject(this) // --> this is doing the inject right now

        // now loginViewModel is available
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // check if injection happened properly
        if (loginViewModel == null) {
            throw java.lang.RuntimeException("injection failed")
        }
    }
}