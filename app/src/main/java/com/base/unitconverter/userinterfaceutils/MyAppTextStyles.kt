package com.base.unitconverter.userinterfaceutils

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.base.unitconverter.userinterfaceutils.extensions.addColon
import com.base.unitconverter.userinterfaceutils.extensions.h1
import com.base.unitconverter.userinterfaceutils.extensions.h2


@Composable
fun TitleBold(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = TextStyle.Default.h1(color),
        modifier = modifier,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TitleMedium(text: String,
              color: Color = MaterialTheme.colorScheme.secondary,
              @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = TextStyle.Default.h2(color),
        modifier = modifier,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextWithColon(text: String
) {
    val modifiedString = text.addColon()
    TitleMedium(text = modifiedString)
}