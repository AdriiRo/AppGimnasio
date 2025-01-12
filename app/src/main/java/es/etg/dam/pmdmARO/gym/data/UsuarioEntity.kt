package es.etg.dam.pmdmARO.gym.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var nombre:String = "",
    var contrasena:String = "",
    var email:String = ""
)
