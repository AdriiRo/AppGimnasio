package es.etg.dam.pmdmARO.gym

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import es.etg.dam.pmdmARO.gym.data.UsuarioDatabase
import es.etg.dam.pmdmARO.gym.data.UsuarioEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var database: UsuarioDatabase
        const val DATABASE_NAME = "usuario-db"
        const val APP  ="corrutinas"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivity.database =  Room.databaseBuilder(this,
            UsuarioDatabase::class.java,
            DATABASE_NAME).build()

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

