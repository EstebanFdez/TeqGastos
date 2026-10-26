package com.example.teqgastos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teqgastos.ui.theme.FondoLimpio
import com.example.teqgastos.ui.theme.TextoSecundario
import com.example.teqgastos.ui.theme.VerdePrincipal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjustesScreen(
    esModoOscuro: Boolean,
    onModoOscuroChange: (Boolean) -> Unit,
    factorEscalaTexto: Float,
    onFactorEscalaChange: (Float) -> Unit,
    onCerrarSesion: () -> Unit,
    onVolver: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajustes de Aplicación", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onVolver) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = FondoLimpio
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Accesibilidad y Visualización", fontWeight = FontWeight.Bold, color = VerdePrincipal)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Modo Oscuro", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("Ajusta el tema para ambientes de poca luz", fontSize = 11.sp, color = TextoSecundario)
                        }
                        Switch(
                            checked = esModoOscuro,
                            onCheckedChange = onModoOscuroChange
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column {
                        Text("Tamaño del texto (${String.format("%.1fx", factorEscalaTexto)})", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text("Desliza para ampliar la letra de la aplicación", fontSize = 11.sp, color = TextoSecundario)
                        Slider(
                            value = factorEscalaTexto,
                            onValueChange = onFactorEscalaChange,
                            valueRange = 0.8f..1.5f,
                            steps = 6
                        )
                    }
                }
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Cuenta y Sesión", fontWeight = FontWeight.Bold, color = VerdePrincipal)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    Button(
                        onClick = onCerrarSesion,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEBEE), contentColor = Color(0xFFC62828)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Icon(Icons.Default.ExitToApp, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Cerrar Sesión Activa", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}