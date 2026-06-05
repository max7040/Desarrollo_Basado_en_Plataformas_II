package com.example.practica5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PantallaComponentes()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaComponentes() {

    var texto by remember { mutableStateOf("") }
    var texto2 by remember { mutableStateOf("") }

    var switchEstado by remember { mutableStateOf(false) }
    var checkEstado by remember { mutableStateOf(false) }

    var sliderValor by remember { mutableFloatStateOf(50f) }

    var mostrarDialogo by remember { mutableStateOf(false) }

    var expanded by remember { mutableStateOf(false) }
    var opcionSeleccionada by remember { mutableStateOf("Opción 1") }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Menú Drawer",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Práctica Componentes") }
                )
            },

            bottomBar = {
                BottomAppBar {
                    Text(
                        text = "BottomBar",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar"
                    )
                }
            }

        ) { padding ->

            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // TEXT
                Text("Componente Text")

                // TEXTFIELD
                TextField(
                    value = texto,
                    onValueChange = { texto = it },
                    label = { Text("TextField") }
                )

                // OUTLINEDTEXTFIELD
                OutlinedTextField(
                    value = texto2,
                    onValueChange = { texto2 = it },
                    label = { Text("OutlinedTextField") }
                )

                // BUTTON
                Button(onClick = {}) {
                    Text("Button")
                }

                // OUTLINED BUTTON
                OutlinedButton(onClick = {}) {
                    Text("OutlinedButton")
                }

                // TEXT BUTTON
                TextButton(onClick = {}) {
                    Text("TextButton")
                }

                // IMAGE
                Text("Image (requiere una imagen en drawable)")
                /*
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                */

                // ICON
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icono"
                )

                // PROGRESS BAR
                LinearProgressIndicator()

                // PROGRESS BAR AVANZADO
                LinearProgressIndicator(
                    progress = { 0.75f }
                )

                // SWITCH
                Switch(
                    checked = switchEstado,
                    onCheckedChange = {
                        switchEstado = it
                    }
                )

                // CHECKBOX
                Checkbox(
                    checked = checkEstado,
                    onCheckedChange = {
                        checkEstado = it
                    }
                )

                // CHECKBOX CON TEXTO
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkEstado,
                        onCheckedChange = {
                            checkEstado = it
                        }
                    )

                    Text("Acepto los términos")
                }

                // CARD
                Card {
                    Text(
                        text = "Ejemplo Card",
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // SURFACE
                Surface(
                    tonalElevation = 6.dp
                ) {
                    Text(
                        text = "Ejemplo Surface",
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // BADGEBOX (Badge)
                BadgedBox(
                    badge = {
                        Badge {
                            Text("5")
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null
                    )
                }

                // DIVIDER
                HorizontalDivider()

                // DROPDOWN MENU
                Box {
                    Button(
                        onClick = {
                            expanded = true
                        }
                    ) {
                        Text(opcionSeleccionada)
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        DropdownMenuItem(
                            text = { Text("Opción 1") },
                            onClick = {
                                opcionSeleccionada = "Opción 1"
                                expanded = false
                            }
                        )

                        DropdownMenuItem(
                            text = { Text("Opción 2") },
                            onClick = {
                                opcionSeleccionada = "Opción 2"
                                expanded = false
                            }
                        )
                    }
                }

                // SLIDER
                Text("Valor Slider: ${sliderValor.toInt()}")

                Slider(
                    value = sliderValor,
                    onValueChange = {
                        sliderValor = it
                    },
                    valueRange = 0f..100f
                )

                // SECTION SLIDER
                Slider(
                    value = sliderValor,
                    onValueChange = {
                        sliderValor = it
                    },
                    steps = 4,
                    valueRange = 0f..100f
                )

                // ALERT DIALOG
                Button(
                    onClick = {
                        mostrarDialogo = true
                    }
                ) {
                    Text("Mostrar AlertDialog")
                }

                if (mostrarDialogo) {
                    AlertDialog(
                        onDismissRequest = {
                            mostrarDialogo = false
                        },
                        title = {
                            Text("Alerta")
                        },
                        text = {
                            Text("Este es un AlertDialog")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    mostrarDialogo = false
                                }
                            ) {
                                Text("Aceptar")
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantalla() {
    MaterialTheme {
        PantallaComponentes()
    }
}