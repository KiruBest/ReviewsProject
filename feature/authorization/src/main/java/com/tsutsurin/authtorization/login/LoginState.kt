package com.tsutsurin.authtorization.login

import com.tsutsurin.android_utils.base.State

sealed class LoginState : State {
    object Loading: LoginState()
    data class Login(val loginForm: LoginForm = LoginForm()): LoginState()
}