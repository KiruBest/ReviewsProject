package com.tsutsurin.authtorization.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsutsurin.authtorization.R
import com.tsutsurin.ui.input.InputField

@Composable
internal fun Login(
    modifier: Modifier = Modifier,
    onNextClicked: () -> Unit,
    onEmailFieldTextChange: (String) -> Unit,
    onPasswordFieldTextChange: (String) -> Unit,
    onEmailFieldFocusChange: (FocusState) -> Unit,
    onPasswordFieldFocusChange: (FocusState) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .defaultMinSize(minHeight = 64.dp, minWidth = 64.dp),
            painter = painterResource(id = R.drawable.login_24),
            contentDescription = stringResource(id = R.string.login_title)
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            value = "",
            placeholder = stringResource(id = R.string.login_email),
            onFocusChange = onEmailFieldFocusChange,
            onValueChange = onEmailFieldTextChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputField(
            value = "",
            placeholder = stringResource(id = R.string.login_pwd),
            onFocusChange = onPasswordFieldFocusChange,
            onValueChange = onPasswordFieldTextChange
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onNextClicked) {
            Text(text = "text")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
internal fun LoginPreview() {
    Login(
        onNextClicked = { /*TODO*/ },
        onEmailFieldTextChange = { /*TODO*/ },
        onPasswordFieldTextChange = { /*TODO*/ },
        onEmailFieldFocusChange = { /*TODO*/ },
        onPasswordFieldFocusChange = { /*TODO*/ }
    )
}