@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.stockexplorer.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockexplorer.core.ui.theme.Black20
import com.example.stockexplorer.core.ui.theme.Black35
import com.example.stockexplorer.core.ui.theme.Black40
import com.example.stockexplorer.core.ui.theme.Black70

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    onSearch: ((String) -> Unit)? = null,
    readOnly: Boolean = true,
) {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(36.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(100.dp, 100.dp, 100.dp, 100.dp))
            .background(color = Black20)
            .padding(horizontal = 12.dp),
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = Icons.Default.Search,
            contentDescription = "Search icon",
            tint = Black40,
        )
        Spacer(modifier = Modifier.width(6.dp))
        TextField(
            value = text,
            placeholder = { Text(text = "搜尋") },
            onValueChange = { text = it },
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearch?.invoke(text)
                // Hide the keyboard after submitting the search
                keyboardController?.hide()
                //or hide keyboard
                focusManager.clearFocus()

            }),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Black70,
                placeholderColor = Black35,
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun SearchBarPreview() {
    SearchBar(readOnly = false)
}
