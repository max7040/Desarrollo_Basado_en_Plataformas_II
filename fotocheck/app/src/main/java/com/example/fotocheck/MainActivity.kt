package com.example.fotocheck

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FotoCheckEmpresa() {

    Card(
        modifier = Modifier
            .width(370.dp)
            .height(240.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // Encabezado
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color(0xFF0D47A1)),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {

                    Text(
                        text = "TECH SOLUTIONS S.A.C.",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Text(
                        text = "CREDENCIAL CORPORATIVA",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                // FOTO
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.foto),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(110.dp)
                            .clip(CircleShape)
                            .border(
                                2.dp,
                                Color.Gray,
                                CircleShape
                            )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "ID: EMP-2026-001",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // DATOS
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "ALI MAXIMO HUISA",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Cargo",
                        color = Color.Gray,
                        fontSize = 11.sp
                    )

                    Text(
                        text = "Desarrollador Android"
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Área",
                        color = Color.Gray,
                        fontSize = 11.sp
                    )

                    Text(
                        text = "Tecnologías Móviles"
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Correo",
                        color = Color.Gray,
                        fontSize = 11.sp
                    )

                    Text(
                        text = "ali@empresa.com"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("QR")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFotoCheckEmpresa() {

    MaterialTheme {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            FotoCheckEmpresa()
        }
    }
}