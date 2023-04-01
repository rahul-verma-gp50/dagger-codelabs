package com.example.ivyaan

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val loginService: LoginRetrofitService
) {
    init {
        if (loginService == null) {
            throw java.lang.RuntimeException("injection failed")
        }
    }
}