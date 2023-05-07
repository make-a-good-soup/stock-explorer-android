package com.example.stockexplorer.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

sealed class SegmentedControlItem {
    data class TextItem(val text: String) : SegmentedControlItem()
    data class IconTextItem(val icon: ImageVector, val text: String) : SegmentedControlItem()
}

@Composable
fun Segmented(
    items: List<SegmentedControlItem>,
    selectedIndex: Int,
    onSelectedIndexChanged: (Int) -> Unit,
    modifier: Modifier = Modifier,
    cornerRadius: Int = 40,
) {
    val contentColor = Color(0xFF1D192B)
    val borderColor = Color(0xFF79747E)
    val selectedBackgroundColor = Color(0xFFE8DEF8)
    val selectedIdx = remember { mutableStateOf(selectedIndex) }

    Row(
        modifier = modifier
            .wrapContentWidth()
            .height(40.dp)
            .background(Color(0xFFFEF7FF), MaterialTheme.shapes.small)
    ) {

        items.forEachIndexed { index, item ->
            OutlinedButton(
                onClick = {
                    selectedIdx.value = index
                    onSelectedIndexChanged(index)
                },
                modifier = when (index) {
                    0 ->
                        Modifier
                            .width(104.dp)
                            .offset(0.dp, 0.dp)
                            .zIndex(if (selectedIdx.value == 0) 1f else 0f)

                    else ->
                        Modifier
                            .width(104.dp)
                            .offset((-1 * index).dp, 0.dp)
                            .zIndex(if (selectedIdx.value == index) 1f else 0f)
                },
                colors = if (selectedIdx.value == index) {
                    ButtonDefaults.outlinedButtonColors(containerColor = selectedBackgroundColor)
                } else {
                    ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
                },
                shape = when (index) {
                    0 -> RoundedCornerShape(
                        topStartPercent = cornerRadius,
                        topEndPercent = 0,
                        bottomStartPercent = cornerRadius,
                        bottomEndPercent = 0
                    )

                    items.size - 1 -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = cornerRadius,
                        bottomStartPercent = 0,
                        bottomEndPercent = cornerRadius
                    )

                    else -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 0,
                        bottomEndPercent = 0
                    )

                },
                border = BorderStroke(1.dp, borderColor),
                content = {
                    when (item) {
                        is SegmentedControlItem.TextItem -> {
                            Text(
                                text = item.text,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                color = contentColor
                            )
                        }

                        is SegmentedControlItem.IconTextItem -> {
                            Row {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "segmented icon",
                                    modifier = Modifier.size(18.dp),
                                    tint = contentColor
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = item.text,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    color = contentColor
                                )
                            }
                        }
                    }

                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultSegmentedPreview() {
    Segmented(
        items = listOf(
            SegmentedControlItem.TextItem("1"),
            SegmentedControlItem.TextItem("2"),
            SegmentedControlItem.TextItem("3"),
        ),
        selectedIndex = 1,
        onSelectedIndexChanged = {},
    )
}