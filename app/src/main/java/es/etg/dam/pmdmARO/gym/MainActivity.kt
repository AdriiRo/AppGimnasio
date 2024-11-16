package es.etg.dam.pmdmARO.gym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que sea el layout correcto

        // Obtener el nombre de usuario desde el Intent
        val userNameTextView = findViewById<TextView>(R.id.textView2)
        val username = intent.getStringExtra("USERNAME_KEY")
        if (username != null) {
            userNameTextView.text = username
        }

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
