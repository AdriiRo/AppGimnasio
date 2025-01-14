package es.etg.dam.pmdmARO.gym

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    var nombre: String,
    var contrasena: String,
    var email: String
) : Parcelable {
    override fun toString(): String {
        return nombre+contrasena+email
    }
}
