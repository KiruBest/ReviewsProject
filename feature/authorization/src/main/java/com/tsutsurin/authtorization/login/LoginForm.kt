package com.tsutsurin.authtorization.login

data class LoginForm(
    val emailInputState: LoginInput = LoginInput(inputType = LoginInputType.EMAIL),
    val passwordInputState: LoginInput = LoginInput(inputType = LoginInputType.PASSWORD),
    val isValid: Boolean = true
)