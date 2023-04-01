package com.example.ivyaan

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val loginService: LoginRetrofitService
) {
}