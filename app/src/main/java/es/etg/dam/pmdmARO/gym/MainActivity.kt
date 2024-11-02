package es.etg.dam.pmdmARO.gym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que sea el layout correcto

        // Configuración del botón "Mi cuenta"
        val miCuentaButton = findViewById<Button>(R.id.button4)
        miCuentaButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Configuración del botón "Generar QR de acceso"
        val generarQRButton = findViewById<Button>(R.id.button)
        generarQRButton.setOnClickListener {
            // Crea un Intent para iniciar QrAccesoActivity
            val intent = Intent(this, QrAccesoActivity::class.java)
            startActivity(intent)
        }
    }
}