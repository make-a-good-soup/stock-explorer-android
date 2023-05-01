package com.example.stockexplorer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockexplorer.ui.theme.*

@Composable
fun MSwitch(
    enabled: Boolean = true,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    val checkedState = remember { mutableStateOf(checked) }

    Switch(
        enabled = enabled,
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
            onCheckedChange?.invoke(checkedState.value)
        },
        modifier = Modifier.size(width = 52.dp, height = 32.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = Black10,
            checkedTrackColor = Blue70,
            uncheckedThumbColor = Black50,
            uncheckedTrackColor = Black20,
            uncheckedBorderColor = Black60,
            disabledCheckedThumbColor = Black10,
            disabledCheckedTrackColor = Blue40,
            disabledUncheckedThumbColor = Black70.copy(alpha = 0.38f),
            disabledUncheckedTrackColor = Black15,
            disabledUncheckedBorderColor = Black35,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column {
        MSwitch(
            checked = true,
            onCheckedChange = {},
        )
        Spacer(modifier = Modifier.height(10.dp))
        MSwitch(
            checked = false,
            onCheckedChange = {},
        )
        Spacer(modifier = Modifier.height(10.dp))
        MSwitch(
            enabled = false,
            checked = true,
            onCheckedChange = {},
        )
        Spacer(modifier = Modifier.height(10.dp))
        MSwitch(
            enabled = false,
            checked = false,
            onCheckedChange = {},
        )
    }
}