package com.zeglius.dialogo_ejercicio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ColorSlider(colorVal: Float, labelString: String, onValueChange: (Float) -> Unit) {
    CentRow(Modifier.fillMaxWidth()) {
        Text(text = labelString, style = MaterialTheme.typography.labelLarge)
        Slider(
            value = colorVal,
            onValueChange = onValueChange
        )
    }
}