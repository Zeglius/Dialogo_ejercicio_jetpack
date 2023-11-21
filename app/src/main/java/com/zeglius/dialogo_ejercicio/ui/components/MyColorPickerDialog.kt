package com.zeglius.dialogo_ejercicio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyColorPickerDialog(
    colorSelected: Color,
    onDismissRequest: () -> Unit,
    onValueChange: (Color) -> Unit,
    onConfirmation: () -> Unit = {  },
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )
    ) {
        Card(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        Modifier
                            .background(colorSelected)
                            .size(65.dp)
                    )
                    Row(
                        Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "R: ${colorSelected.red}",
                            )
                            Text(
                                text = "G: ${colorSelected.green}",
                            )
                            Text(
                                text = "B: ${colorSelected.blue}",
                            )
                        }

                    }
                }

                ColorSlider(
                    colorVal = colorSelected.red,
                    labelString = "Red",
                    onValueChange = { onValueChange(colorSelected.copy(red = it)) }
                )

                ColorSlider(
                    colorVal = colorSelected.green,
                    labelString = "Green",
                    onValueChange = { onValueChange(colorSelected.copy(green = it)) }
                )
                ColorSlider(
                    colorVal = colorSelected.blue,
                    labelString = "Blue",
                    onValueChange = { onValueChange(colorSelected.copy(blue = it)) }
                )

                Row(Modifier.align(Alignment.End)) {
                    Button(onClick = { onConfirmation() }) {
                        Text(text = "Ok")
                    }
                }
            }

        }
    }
}