package com.example.laboratorio1danp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel( private val dao:AsistenteDao) : ViewModel(){

    var state by mutableStateOf(MainState())
    private set

    init{
        viewModelScope.launch {
            dao.getAllAsistente().collectLatest {
                state = state.copy(
                    asistentes = it
                )
            }
        }
    }

    fun changeName(name: String){
        state = state.copy(
            asistenteName = name
        )
    }
    fun changeFecha(fecha: String){
        state = state.copy(
            asistenteFecha = fecha
        )
    }
    fun changeBlood(blood: String){
        state = state.copy(
            asistenteBlood = blood
        )
    }
    fun changePhone(phone: String){
        state = state.copy(
            asistentePhone = phone
        )
    }
    fun changeEmail(email: String){
        state = state.copy(
            asistenteEmail = email
        )
    }
    fun changeMonto(monto: String){
        state = state.copy(
            asistenteMonto = monto
        )
    }
    fun deleteAsistente(asistente: Asistente){
        viewModelScope.launch {
            dao.deleteAsistente(asistente)
        }
    }
    fun editAsistente(asistente: Asistente){
        state = state.copy(
            asistenteName = asistente.name,
            asistenteFecha = asistente.fecha,
            asistenteBlood = asistente.blood,
            asistentePhone = asistente.phone.toString(),
            asistenteEmail = asistente.email,
            asistenteMonto = asistente.monto.toString(),
            asistenteId = asistente.id

        )

    }

    fun createAsistente(){
        val asistente = Asistente(
            state.asistenteId?: UUID.randomUUID().toString(),
            state.asistenteName,
            state.asistenteFecha,
            state.asistenteBlood,
            state.asistentePhone.toLong(),
            state.asistenteEmail,
            state.asistenteMonto.toDouble())
        viewModelScope.launch {
            dao.insertAsistente(asistente)
        }
        state = state.copy(
            asistenteId = null,
            asistenteName = "",
            asistenteFecha = "",
            asistenteBlood = "",
            asistentePhone = "",
            asistenteEmail = "",
            asistenteMonto = ""
        )


    }


}