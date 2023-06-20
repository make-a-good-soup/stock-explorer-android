@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.stockexplorer.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockexplorer.core.ui.theme.Black20
import com.example.stockexplorer.core.ui.theme.Black35
import com.example.stockexplorer.core.ui.theme.Black40

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: ((String) -> Unit)? = null,
    readOnly: Boolean = true,
) {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(
            fontSize = 13.sp,
            color = Color.Black
        ),
        singleLine = true,
        readOnly = readOnly,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onSearch?.invoke(text)
            // Hide the keyboard after submitting the search
            keyboardController?.hide()
            //or hide keyboard
            focusManager.clearFocus()

        }),
        decorationBox = { innerTextField ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Black20, shape = RoundedCornerShape(size = 100.dp))
                    .padding(all = 12.dp), // inner padding
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon",
                    tint = Black40,
                )
                Spacer(modifier = Modifier.width(width = 6.dp))
                if (text.isEmpty()) {
                    Text(
                        text = "搜尋",
                        fontSize = 13.sp,
                        color = Black35,
                    )
                } else {
                    innerTextField()
                }

            }
        },
    )
}

@Preview(showBackground = false)
@Composable
private fun SearchBarPreview() {
    SearchBar(readOnly = false)
}
