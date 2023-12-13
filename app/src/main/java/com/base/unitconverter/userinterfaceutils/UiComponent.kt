package com.base.unitconverter.userinterfaceutils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyAppOutlineTextField(placeholder: String, onValueChange: (String) -> Unit = {}) {
    OutlinedTextField(value = placeholder, onValueChange = onValueChange)
}

@Composable
fun WidthSpacer(width: Int) {
    Spacer(
        modifier = Modifier
            .width(width.dp)
            .fillMaxHeight()
    )
}


@Composable
fun HeightSpacer(height: Int) {
    Spacer(
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
    )
}

@Composable
fun MyAppButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
    cornerShape: Int = 20,
    onCLick: () -> Unit
) {
    Button(
        onClick = { onCLick() },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = modifier.background(color = color, shape = RoundedCornerShape(cornerShape.dp))
    ) {
        TitleMedium(text = text, color = Color.White)
        Icon(
            Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown button to select centimeter"
        )
    }
}



