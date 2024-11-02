package es.etg.dam.pmdmARO.gym

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Cambia a tu layout actual si es diferente

        // Configura el botón "Iniciar sesión" para que navegue a MainActivity
        val iniciarSesionButton = findViewById<Button>(R.id.button6)
        iniciarSesionButton.setOnClickListener {
            // Crea un Intent para abrir MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}