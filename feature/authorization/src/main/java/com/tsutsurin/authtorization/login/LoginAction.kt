package com.tsutsurin.authtorization.login

import com.tsutsurin.android_utils.base.Action

sealed class LoginAction : Action {
    data class EnteredEmail(val value: String): LoginAction()
    data class EnteredPassword(val value: String): LoginAction()
}
