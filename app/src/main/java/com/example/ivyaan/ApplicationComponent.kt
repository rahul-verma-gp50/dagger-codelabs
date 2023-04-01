package com.example.ivyaan

import dagger.Component
import javax.inject.Singleton

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: LoginActivity)
}