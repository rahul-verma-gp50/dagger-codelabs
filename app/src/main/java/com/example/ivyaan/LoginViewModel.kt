package com.example.ivyaan

import javax.inject.Inject

// @Inject tells Dagger how to create instances of LoginViewModel

// A unique instance of LoginViewModel is provided in Components
//  annotated with @UserScope
// Now, if you had two fragments that need LoginViewModel, both of them are provided with the same instance.
@UserScope
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) {
    init {
        if (userRepository == null) {
            throw java.lang.RuntimeException("injection failed")
        }
    }
}