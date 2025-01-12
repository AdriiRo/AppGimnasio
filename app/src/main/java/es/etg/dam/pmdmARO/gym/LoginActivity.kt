package es.etg.dam.pmdmARO.gym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import es.etg.dam.pmdmARO.gym.preferences.PreferenciasUsuario

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.tvUsuario)
        val iniciarSesionButton = findViewById<Button>(R.id.btnIniciarSesion)
        val registrarButton = findViewById<Button>(R.id.btnRegistrar)

        // Instancia de PreferenciasUsuario
        val preferenciasUsuario = PreferenciasUsuario(this)

        // Leer el nombre guardado en las preferencias y mostrarlo en el EditText
        val nombreGuardado = preferenciasUsuario.leer()
        if (!nombreGuardado.isNullOrEmpty()) {
            usernameEditText.setText(nombreGuardado)
        }

        // Configurar el botón de iniciar sesión
        iniciarSesionButton.setOnClickListener {
            // Obtener el nombre introducido por el usuario
            val username = usernameEditText.text.toString()

            // Guardar el nombre en las preferencias
            preferenciasUsuario.guardar(username)

            // Pasar el nombre introducido a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USERNAME_KEY", username) // Pasamos el nombre
            startActivity(intent)
        }

        registrarButton.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
    }
}
