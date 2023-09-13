package com.tsutsurin.authtorization.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    LoginScreen(
        state = LoginState.Default,
        onGoBack = onGoBack,
        onNextClicked = { /*TODO*/ },
        onEmailFieldTextChange = { value ->
            viewModel.sendAction(LoginAction.EnteredEmail(value))
        },
        onPasswordFieldTextChange = { value ->
            viewModel.sendAction(LoginAction.EnteredPassword(value))
        },
        onEmailFieldFocusChange = { /*TODO*/ },
        onPasswordFieldFocusChange = { /*TODO*/ }
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    onGoBack: () -> Unit,
    onNextClicked: () -> Unit,
    onEmailFieldTextChange: (String) -> Unit,
    onPasswordFieldTextChange: (String) -> Unit,
    onEmailFieldFocusChange: (FocusState) -> Unit,
    onPasswordFieldFocusChange: (FocusState) -> Unit
) {
    Login(
        onNextClicked = onNextClicked,
        onEmailFieldTextChange = onEmailFieldTextChange,
        onPasswordFieldTextChange = onPasswordFieldTextChange,
        onEmailFieldFocusChange = onEmailFieldFocusChange,
        onPasswordFieldFocusChange = onPasswordFieldFocusChange
    )
}