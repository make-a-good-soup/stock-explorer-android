package com.example.stockexplorer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockexplorer.ui.theme.Blue70

@Composable
fun MSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = Modifier.size(width = 52.dp, height = 32.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Blue70,
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color(0xFFF0F0F0), // FIXME: 顏色未定義在 DesignSystem
            uncheckedBorderColor = Color(0xFFF0F0F0), // FIXME: 待確認顏色
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
    }
}