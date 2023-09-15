package com.tsutsurin.authtorization.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val currentState by viewModel.state.collectAsState()
    val loginScreenListener = LoginScreenListenerImpl(
        onGoBack = onGoBack,
        onForgotPasswordClicked = {},
        onEmailFieldFocusChange = {},
        onEmailFieldTextChange = { value ->
            viewModel.sendAction(LoginAction.EnteredEmail(value))
        },
        onPasswordFieldFocusChange = {},
        onPasswordFieldTextChange = { value ->
            viewModel.sendAction(LoginAction.EnteredPassword(value))
        },
        onSignInClicked = {},
        onSignUpClicked = {}
    )

    LoginScreen(
        modifier = modifier,
        state = currentState,
        loginScreenListener = loginScreenListener
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    loginScreenListener: LoginScreenListener
) {
    when (state) {
        LoginState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Blue, strokeWidth = 2.dp)
        }

        is LoginState.Login -> Login(
            modifier = modifier,
            loginScreenListener = loginScreenListener,
            loginState = state
        )
    }
}