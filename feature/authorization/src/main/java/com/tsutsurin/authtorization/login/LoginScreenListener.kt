package com.tsutsurin.authtorization.login

import androidx.compose.ui.focus.FocusState

internal interface LoginScreenListener {
    val onGoBack: () -> Unit
    val onSignInClicked: () -> Unit
    val onEmailFieldTextChange: (String) -> Unit
    val onPasswordFieldTextChange: (String) -> Unit
    val onEmailFieldFocusChange: (FocusState) -> Unit
    val onPasswordFieldFocusChange: (FocusState) -> Unit
    val onForgotPasswordClicked: () -> Unit
    val onSignUpClicked: () -> Unit
}

internal class LoginScreenListenerImpl(
    override val onGoBack: () -> Unit,
    override val onSignInClicked: () -> Unit,
    override val onEmailFieldTextChange: (String) -> Unit,
    override val onPasswordFieldTextChange: (String) -> Unit,
    override val onEmailFieldFocusChange: (FocusState) -> Unit,
    override val onPasswordFieldFocusChange: (FocusState) -> Unit,
    override val onForgotPasswordClicked: () -> Unit,
    override val onSignUpClicked: () -> Unit
) : LoginScreenListener {
    constructor() : this(
        onGoBack = {},
        onSignInClicked = {},
        onEmailFieldTextChange = {},
        onPasswordFieldTextChange = {},
        onEmailFieldFocusChange = {},
        onPasswordFieldFocusChange = {},
        onForgotPasswordClicked = {},
        onSignUpClicked = {}
    )
}