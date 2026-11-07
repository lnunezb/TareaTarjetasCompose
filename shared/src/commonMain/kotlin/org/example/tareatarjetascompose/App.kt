package org.example.tareatarjetascompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tareatarjetascompose.shared.generated.resources.Res
import tareatarjetascompose.shared.generated.resources.avatar
import tareatarjetascompose.shared.generated.resources.avatar2
import tareatarjetascompose.shared.generated.resources.avatar3

// Imágen y colorines especificos por cada tarjeta
data class Perfil(
    val nombre: String,
    val rol: String,
    val correo: String,
    val ciudad: String,
    val imagen: DrawableResource,
    val colorAcento: Color,
    val colorBorde: Color
)

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF1F5F9)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Tarjeta 1
                TarjetaPerfil(
                    Perfil(
                        nombre = "Elvira Ocaña Rodríguez",
                        rol = "Desarrolladora Frontend & UI",
                        correo = "elvira.ocana@techmallorca.es",
                        ciudad = "Palma",
                        imagen = Res.drawable.avatar,
                        colorAcento = Color(0xFF0F766E),
                        colorBorde = Color(0xFF14B8A6)
                    )
                )

                // Tarjeta 2
                TarjetaPerfil(
                    Perfil(
                        nombre = "Ginés Ocaña Rodríguez",
                        rol = "Desarrollador Backend & Cloud",
                        correo = "gines.ocana@balearesdev.org",
                        ciudad = "Inca",
                        imagen = Res.drawable.avatar2,
                        colorAcento = Color(0xFF6D28D9), // Violeta intenso
                        colorBorde = Color(0xFF8B5CF6)   // Morado medio
                    )
                )

                // Tarjeta 3
                TarjetaPerfil(
                    Perfil(
                        nombre = "Gustavo Ocaña Rodríguez",
                        rol = "Desarrollador Multiplataforma DAM",
                        correo = "gustavo.ocana@dinamicsolutions.com",
                        ciudad = "Manacor",
                        imagen = Res.drawable.avatar3,
                        colorAcento = Color(0xFFC2410C),
                        colorBorde = Color(0xFFF97316)
                    )
                )
            }
        }
    }
}

@Composable
fun TarjetaPerfil(
    perfil: Perfil,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen de perfil
            Image(
                painter = painterResource(perfil.imagen),
                contentDescription = "Foto de perfil de ${perfil.nombre}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(76.dp)
                    .clip(CircleShape)
                    .border(2.5.dp, perfil.colorBorde, CircleShape)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Nombre
                Text(
                    text = perfil.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                )

                Spacer(modifier = Modifier.height(3.dp))

                // Rol
                Text(
                    text = perfil.rol,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = perfil.colorAcento
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Divisor horizontal
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFE2E8F0)
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Email
                Row {
                    Text(
                        text = "Correo: ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF475569)
                    )
                    Text(
                        text = perfil.correo,
                        fontSize = 13.sp,
                        color = perfil.colorAcento
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Ciudad
                Row {
                    Text(
                        text = "Ciudad: ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF475569)
                    )
                    Text(
                        text = perfil.ciudad,
                        fontSize = 13.sp,
                        color = Color(0xFF64748B)
                    )
                }
            }
        }
    }
}