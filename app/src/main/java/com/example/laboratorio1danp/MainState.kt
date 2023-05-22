package com.example.laboratorio1danp

data class MainState (
    val asistentes: List<Asistente> = emptyList(),
    val asistenteId : String? = null,
    val asistenteName : String = "",
    val asistenteFecha : String = "",
    val asistenteBlood: String = "",
    val asistentePhone: String = "",
    val asistenteEmail: String = "",
    val asistenteMonto: String = ""
)


