package com.tsutsurin.authtorization.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsutsurin.authtorization.R
import com.tsutsurin.ui.input.InputField

@Composable
internal fun Login(
    modifier: Modifier = Modifier,
    loginScreenListener: LoginScreenListener,
    loginState: LoginState.Login
) {
    val loginForm = loginState.loginForm
    val emailInputState = loginForm.emailInputState
    val passwordInputState = loginForm.passwordInputState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            modifier = Modifier
                .defaultMinSize(minHeight = 60.dp, minWidth = 60.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_popcorn_60),
            contentDescription = stringResource(id = R.string.login_title)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.login_title)
        )
        Spacer(modifier = Modifier.height(42.dp))
        InputField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = emailInputState.text,
            placeholder = stringResource(id = R.string.login_email),
            onFocusChange = loginScreenListener.onEmailFieldFocusChange,
            onValueChange = loginScreenListener.onEmailFieldTextChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = passwordInputState.text,
            placeholder = stringResource(id = R.string.login_pwd),
            onFocusChange = loginScreenListener.onPasswordFieldFocusChange,
            onValueChange = loginScreenListener.onPasswordFieldTextChange
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.align(Alignment.End)) {
            TextButton(
                onClick = loginScreenListener.onForgotPasswordClicked
            ) {
                Text(text = stringResource(id = R.string.login_forgotPassword))
            }
            Spacer(modifier = Modifier.width(32.dp))
        }
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = loginScreenListener.onSignInClicked
        ) {
            Text(text = stringResource(id = R.string.login_signIn))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = stringResource(id = R.string.login_haveAccount))
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                modifier = Modifier.clickable(onClick = loginScreenListener.onSignUpClicked),
                text = stringResource(id = R.string.login_signUp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
internal fun LoginPreview() {
    Login(
        loginScreenListener = LoginScreenListenerImpl(),
        loginState = LoginState.Login()
    )
}