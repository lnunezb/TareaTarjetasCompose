package org.example.tareatarjetascompose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tarjetas de Presentación - DAM"
    ) {
        App()
    }
}