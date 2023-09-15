package com.tsutsurin.authtorization.login

data class LoginInput(
    val text: String = "",
    val isValid: Boolean = true,
    val inputType: LoginInputType,
    val errorMessage: String = ""
)