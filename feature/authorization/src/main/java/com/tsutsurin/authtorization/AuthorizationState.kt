package com.tsutsurin.authtorization

sealed interface AuthorizationState {
    object Default: AuthorizationState
    //TODO Kirill: (Create state)
}