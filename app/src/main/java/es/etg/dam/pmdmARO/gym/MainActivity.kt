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
import es.etg.dam.pmdmARO.gym.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    companion object {
        lateinit var database: UsuarioDatabase
        const val DATABASE_NAME = "usuario-db"
        const val APP  ="corrutinas"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainActivity.database =  Room.databaseBuilder(this,
            UsuarioDatabase::class.java,
            DATABASE_NAME).build()

        // Leer el nombre de usuario desde el Intent
        val userNameTextView = binding.textView2
        val username = intent.getStringExtra("USERNAME_KEY") // Obtenemos el nombre del Intent

        // Mostrar el nombre en el TextView
        userNameTextView.text = username ?: "Usuario no encontrado"

        // Configurar el botón "Mi cuenta"
        val miCuentaButton = binding.button4
        miCuentaButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón "Generar QR de acceso"
        val generarQRButton = binding.button
        generarQRButton.setOnClickListener {
            val intent = Intent(this, QrAccesoActivity::class.java)
            startActivity(intent)
        }
    }
}

