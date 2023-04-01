package com.example.ivyaan

import javax.inject.Scope

// Definition of a custom scope called ActivityScope

// The LoginComponent must always provide the same instance of LoginViewModel
// each time it's requested. You can ensure this by creating a custom annotation scope
// and annotating both LoginComponent and LoginViewModel with it.
// Note that you cannot use the @Singleton annotation because (if) it's already been used by the parent
// component and that'd make the object an application singleton (unique instance for the whole app).
// You need to create a different annotation scope.
@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class UserScope {
}