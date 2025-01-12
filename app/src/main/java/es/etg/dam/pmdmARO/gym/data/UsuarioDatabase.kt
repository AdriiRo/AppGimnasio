package es.etg.dam.pmdmARO.gym.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsuarioEntity::class], version = 1)
abstract class UsuarioDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}