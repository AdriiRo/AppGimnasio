package es.etg.dam.pmdmARO.gym.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Query ("SELECT id,nombre, contrasena, email FROM usuario")
    suspend fun getAll(): List <UsuarioEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (usuario: UsuarioEntity)

    @Delete
    suspend fun delete(usuario: UsuarioEntity)

}