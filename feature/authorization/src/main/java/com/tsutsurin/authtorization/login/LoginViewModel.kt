package com.tsutsurin.authtorization.login

import androidx.lifecycle.viewModelScope
import com.tsutsurin.android_utils.base.BaseViewModel
import com.tsutsurin.android_utils.extentions.launchOnDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel<LoginState, LoginAction, LoginEvent>() {
    override val _state: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Loading)
    override val state: StateFlow<LoginState> = _state.asStateFlow()

    override val _actions: Channel<LoginAction> = Channel(Channel.RENDEZVOUS)

    init {
        observeAction()
        launchOnDefault {
            delay(1000)
            _state.value = LoginState.Login()
        }
    }

    override fun handleAction(action: LoginAction) {
        when (action) {
            is LoginAction.EnteredEmail -> _state.update { currentState ->
                when(currentState) {
                    LoginState.Loading -> currentState
                    is LoginState.Login -> {
                        val currentLoginForm = currentState.loginForm
                        val updatedEmailInputState = currentLoginForm.emailInputState.copy(
                            text = action.value
                        )
                        val updatedLoginForm = currentLoginForm.copy(
                            emailInputState = updatedEmailInputState
                        )
                        currentState.copy(loginForm = updatedLoginForm)
                    }
                }
            }

            is LoginAction.EnteredPassword -> _state.update { currentState ->
                when(currentState) {
                    LoginState.Loading -> currentState
                    is LoginState.Login -> {
                        val currentLoginForm = currentState.loginForm
                        val updatedPasswordInputState = currentLoginForm.passwordInputState.copy(
                            text = action.value
                        )
                        val updatedLoginForm = currentLoginForm.copy(
                            passwordInputState = updatedPasswordInputState
                        )
                        currentState.copy(loginForm = updatedLoginForm)
                    }
                }
            }
        }
    }
}