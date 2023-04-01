package com.example.ivyaan

import javax.inject.Inject

// @Inject tells Dagger how to create instances of LoginViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) {
}