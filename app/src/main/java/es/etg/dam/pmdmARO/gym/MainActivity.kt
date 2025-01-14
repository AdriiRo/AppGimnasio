package es.etg.dam.pmdmARO.gym

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Room
import es.etg.dam.pmdmARO.gym.data.UsuarioDatabase
import es.etg.dam.pmdmARO.gym.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    companion object {
        lateinit var database: UsuarioDatabase
        const val DATABASE_NAME = "usuario-db"
        const val APP  ="corrutinas"
        const val READ_EXTERNAL_STORAGE_REQUEST_CODE = 0
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

        val btn = binding.btnPermisos

        btn.setOnClickListener{
            checkReadExternalStoragePermission()
        }
    }

    //Comprueba si tiene permisos
    private fun checkReadExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            //El permiso de acceso a los contactos no está aceptado, se pide
            requestReadExternalStoragePermission()
        } else {
            //El permiso está aceptado
            //aquí añadiríamos la lógica sobre los contactos
            Toast.makeText(this,"Acceso a la funcionalidad", Toast.LENGTH_SHORT).show()
        }
    }

    //Solicita el permiso
    private fun requestReadExternalStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //El usuario ya ha rechazado el permiso anteriormente, debemos indicarle que vaya a ajustes.
            Toast.makeText(this,"Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
        } else {
            //El usuario nunca ha aceptado ni rechazado, así que le solicitamos que acepte el permiso.
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                Companion.READ_EXTERNAL_STORAGE_REQUEST_CODE
            )
        }
    }

    //Este método escucha la respuesta del usuario ante una solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_EXTERNAL_STORAGE_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //El usuario ha aceptado el permiso, ya no hay que volver a solicitarlo, podemos lanzar la funcionalidad desde aquí.
                    Toast.makeText(this,"Acceso a la funcionalidad una vez aceptado el permiso", Toast.LENGTH_SHORT).show()
                } else {
                    //El usuario ha rechazado el permiso
                    Toast.makeText(this,"Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
                // Para aquellos permisos no controlados
            }
        }
    }

}

