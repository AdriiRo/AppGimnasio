package es.etg.dam.pmdmARO.gym.preferences

import android.content.Context

private const val PREFERENCIAS_USER = "PreferenciasUser"
private const val NOMBRE = "nombre"

class PreferenciasUsuario(private val context: Context) {

    fun guardar(nombre: String) {
        val sharedPref = context.getSharedPreferences(PREFERENCIAS_USER, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(NOMBRE, nombre)
        editor.apply()
    }

    fun leer(): String? {
        val sharedPref = context.getSharedPreferences(PREFERENCIAS_USER, Context.MODE_PRIVATE)
        return sharedPref.getString(NOMBRE, null)
    }
}
