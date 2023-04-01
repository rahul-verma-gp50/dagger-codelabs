package com.example.ivyaan

import dagger.Component
import javax.inject.Singleton

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Component(modules = [NetworkModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    //fun inject(activity: LoginActivity) --> this is now moved to LoginComponent


    // This function exposes the LoginComponent Factory out of the graph so consumers
    // can use it to obtain new instances of LoginComponent
    fun loginComponent(): LoginComponent.Factory
}