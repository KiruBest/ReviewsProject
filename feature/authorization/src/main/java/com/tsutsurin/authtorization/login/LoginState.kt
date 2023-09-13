package com.tsutsurin.authtorization.login

import com.tsutsurin.android_utils.base.State

sealed class LoginState : State {
    object Default: LoginState()
    //TODO Kirill: (Create state)
}