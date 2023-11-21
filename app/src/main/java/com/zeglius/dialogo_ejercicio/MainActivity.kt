package com.zeglius.dialogo_ejercicio

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.zeglius.dialogo_ejercicio.ui.components.MyColorPickerDialog
import com.zeglius.dialogo_ejercicio.ui.theme.Dialogo_ejercicioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dialogo_ejercicioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen(
    isDialogVisible: Boolean = false,
) {
    var isColorPickerVisible by remember { mutableStateOf(isDialogVisible) }
    var isMessageDialogVisible by remember { mutableStateOf(false) }
    var colorSelected by remember { mutableStateOf(Color.Red) }
    var context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { isColorPickerVisible = true }) {
            Text(text = "Mostrar dialogo")
        }

        if (isColorPickerVisible) {
            val closeDialog = { isColorPickerVisible = false }
            MyColorPickerDialog(
                colorSelected = colorSelected,
                onDismissRequest = closeDialog,
                onConfirmation = {
                    closeDialog()
                    // Toast.makeText(context, "The color is $colorSelected", Toast.LENGTH_SHORT)
                    //     .show()
                    isMessageDialogVisible = true
                },
                onValueChange = { colorSelected = it }
            )
        }

        if (isMessageDialogVisible) {
            val onDismissRequest = { isMessageDialogVisible = false }
            AlertDialog(
                onDismissRequest = onDismissRequest,
                confirmButton = { /*TODO*/ },
                text = { Text("The color is $colorSelected") },
                dismissButton = {
                    TextButton(onClick = onDismissRequest) {
                        Text(text = "Ok")
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview() {
    MainScreen(isDialogVisible = true)
}