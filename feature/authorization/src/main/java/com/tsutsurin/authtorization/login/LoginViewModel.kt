package com.tsutsurin.authtorization.login

import com.tsutsurin.android_utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel<LoginState, LoginAction, LoginEvent>() {
    override val _state = MutableStateFlow(LoginState.Default)
    override val state: StateFlow<LoginState> = _state.asStateFlow()

    override val _actions: Channel<LoginAction> = Channel(Channel.RENDEZVOUS)

    init {
        observeAction()
    }

    override fun handleAction(action: LoginAction) {
        when (action) {
            is LoginAction.EnteredEmail -> TODO()
            is LoginAction.EnteredPassword -> TODO()
        }
    }
}