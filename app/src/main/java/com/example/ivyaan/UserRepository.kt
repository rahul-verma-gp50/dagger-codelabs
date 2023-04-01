package com.example.ivyaan

import javax.inject.Inject
import javax.inject.Singleton

class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) {
    init {
        if (localDataSource == null || remoteDataSource == null) {
            throw java.lang.RuntimeException("injection failed")
        }
    }
}