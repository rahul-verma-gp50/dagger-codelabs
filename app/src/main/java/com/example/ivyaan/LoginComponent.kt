package com.example.ivyaan

import dagger.Subcomponent

// Scenario: lets say you want to have a login flow, which starts with loginActivity (and multiple fragments) and ends when loginActivity dies
// So, login flow is manager by single LoginActivity, and consists of multiple fragments, which should use same instance of LoginViewModel in all fragments
// We want different instance of LoginViewModel for each flow (use logs out, and re-logs in back)
// we need to scope LoginViewModel to lifecycle of LoginActivity
// we need to create new sub-graph / sub-component for login flow and a new scope
// Now LoginActivity should get injections from LoginComponent, not ApplicationComponent (which lives throughout app lifecycle)
// @singleton annotation can't be used here

// Classes annotated with @LoginScope are scoped to the graph and the same
// instance of that type is provided every time the type is requested.

@UserScope
@Subcomponent
interface LoginComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    // This tells Dagger that LoginActivity requests injection from LoginComponent
    // so that this subcomponent graph needs to satisfy all the dependencies of the
    // fields that LoginActivity is injecting

    // injection to LoginActivity -> needs injection to LoginViewModel -> which needs UserRepository access which is part
    // of ApplicationComponent , therefore this component needs to access objects from ApplicationComponent
    // this is done by sub-component, new component should be subcomponent of the component containing shared resources

    // Subcomponents are components that inherit and extend the object graph of a parent component.
    // Thus, all objects provided in the parent component are provided in the subcomponent too.
    // In this way, an object from a subcomponent can depend on an object provided by the parent component.

    // To create instances of subcomponents, you need an instance of the parent component.
    // (define a subcomponent factory inside LoginComponent so that ApplicationComponent knows how to create instances of LoginComponent.)
    // Therefore, the objects provided by the parent component to the subcomponent are still scoped to the parent component.

    // To tell Dagger that LoginComponent is a subcomponent of ApplicationComponent, you have to indicate it by:
    // Creating a new Dagger module (e.g. SubcomponentsModule) passing the subcomponent's class to the subcomponents attribute of the annotation.
    // Adding the new module (i.e. SubcomponentsModule) to ApplicationComponent:

    // LoginActivity is the right lifetime for LoginComponent:
    // for every new activity, you need a new instance of LoginComponent and fragments that can use that instance of LoginComponent.
    // Because LoginComponent is attached to the LoginActivity lifecycle, you have to keep a reference to the component in the activity
    // in the same way you kept the reference to the applicationComponent in the Application class. That way, fragments can access it.
    fun inject(loginActivity: LoginActivity)
    fun inject(usernameFragment: LoginUsernameFragment)
    // fun inject(passwordFragment: LoginPasswordFragment) ... similarly for all login related fragments ...
}