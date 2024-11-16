package es.etg.dam.pmdmARO.gym

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.editTextText)
        val iniciarSesionButton = findViewById<Button>(R.id.button6)

        // Configura el botón de Iniciar Sesión para que navegue a MainActivity
        iniciarSesionButton.setOnClickListener {
            // Obtener el nombre del usuario
            val username = usernameEditText.text.toString()

            // Crea un Intent para abrir MainActivity y pasa el nombre de usuario
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USERNAME_KEY", username)
            startActivity(intent)
        }
    }
}
