package com.example.laboratorio1danp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Asistente::class], version = 1)
abstract class AsistenteDatabase: RoomDatabase() {
    abstract val dao: AsistenteDao

}