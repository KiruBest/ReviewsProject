@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.tsutsurin.authtorization

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.tsutsurin.ui.InputField

@Composable
fun AuthorizationRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
//    viewModel: ViewModel = hiltViewModel()
) {
    //TODO Kirill: Add viewModel
    AuthorizationScreen(state = AuthorizationState.Default, onGoBack = onGoBack)
}

@Composable
internal fun AuthorizationScreen(
    state: AuthorizationState,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Authorization()
}

@Composable
internal fun Authorization(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.auth_title)) })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(value = "", placeholder = "text", onFocusChange = {}, onValueChange = {})
            Spacer(modifier = Modifier.height(16.dp))
            InputField(value = "", placeholder = "text", onFocusChange = {}, onValueChange = {})
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "text")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
internal fun AuthorizationPreview() {
    Authorization()
}