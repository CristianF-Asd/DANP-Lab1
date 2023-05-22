package com.example.laboratorio1danp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio1danp.AsistenteItem
import com.example.laboratorio1danp.MainViewModel

@Composable
fun MainScreen (viewModel: MainViewModel) {
    val state = viewModel.state
    Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Asistentes al Congreso", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

        TextField(
            value = state.asistenteName,
            onValueChange = { viewModel.changeName(it) },
            placeholder = { Text(text = "Nombre del Asistente") }
        )
        TextField(
            value = state.asistenteFecha,
            onValueChange = { viewModel.changeFecha(it) },
            placeholder = { Text(text = "Fecha de Asistencia") }
        )

        TextField(
            value = state.asistenteBlood,
            onValueChange = { viewModel.changeBlood(it) },
            placeholder = { Text(text = "Grupo Sanguineo") }
        )
        TextField(
            value = state.asistentePhone,
            onValueChange = { viewModel.changePhone(it) },
            placeholder = { Text(text = "Telefono") }
        )

        TextField(
            value = state.asistenteEmail,
            onValueChange = { viewModel.changeEmail(it) },
            placeholder = { Text(text = "E-mail") }
        )

        TextField(
            value = state.asistenteMonto,
            onValueChange = { viewModel.changeMonto(it) },
            placeholder = { Text(text = "Monto Inicial") }
        )

        Button(onClick = { viewModel.createAsistente() }) {
            Text(text = "Agregar Asistente")
        }


        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.asistentes) {
                    AsistenteItem(asistente=it, modifier = Modifier.fillMaxWidth(),
                        onEdit= {
                                viewModel.editAsistente(it)
                        }, onDelete= {
                            viewModel.deleteAsistente(it);
                        })


            }
        }
    }
}