package com.tsutsurin.android_utils.base

import androidx.lifecycle.ViewModel
import com.tsutsurin.android_utils.extentions.launchOnDefault
import com.tsutsurin.android_utils.extentions.launchOnIO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow

abstract class BaseViewModel<S : State, A : Action, E : Event> : ViewModel() {

    protected abstract val _state: MutableStateFlow<out S>
    abstract val state: StateFlow<S>

    protected abstract val _actions: Channel<A>

    fun sendAction(action: A) {
        launchOnIO {
            _actions.send(action)
        }
    }

    protected abstract fun handleAction(action: A)

    protected fun observeAction() {
        launchOnDefault {
            _actions.consumeAsFlow().collect(::handleAction)
        }
    }
}