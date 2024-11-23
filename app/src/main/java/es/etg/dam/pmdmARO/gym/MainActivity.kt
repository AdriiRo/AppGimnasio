package es.etg.dam.pmdmARO.gym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Leer el nombre de usuario desde el Intent
        val userNameTextView = findViewById<TextView>(R.id.textView2)
        val username = intent.getStringExtra("USERNAME_KEY") // Obtenemos el nombre del Intent

        // Mostrar el nombre en el TextView
        userNameTextView.text = username ?: "Usuario no encontrado"

        // Configurar el botón "Mi cuenta"
        val miCuentaButton = findViewById<Button>(R.id.button4)
        miCuentaButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón "Generar QR de acceso"
        val generarQRButton = findViewById<Button>(R.id.button)
        generarQRButton.setOnClickListener {
            val intent = Intent(this, QrAccesoActivity::class.java)
            startActivity(intent)
        }
    }
}
