package com.example.laboratorio1danp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Asistente (
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val fecha: String,
    val blood: String,
    val phone: Long,
    val email: String,
    val monto: Double

)