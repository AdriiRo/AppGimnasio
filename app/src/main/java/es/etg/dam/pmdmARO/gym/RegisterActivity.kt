package es.etg.dam.pmdmARO.gym

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import es.etg.dam.pmdmARO.gym.data.UsuarioDatabase
import es.etg.dam.pmdmARO.gym.data.UsuarioEntity
import es.etg.dam.pmdmARO.gym.databinding.ActivityRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {


    companion object {
        lateinit var database: UsuarioDatabase
        const val DATABASE_NAME = "usuario-db"
    }

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        database =  Room.databaseBuilder(this,
            UsuarioDatabase::class.java,
            DATABASE_NAME).build()

        binding.btnIniciarSesion2.setOnClickListener {
            guardar(it)
        }
    }

    fun guardar(view: View){

        val nombre: String = binding.tvUsuario.text.toString()
        val contrasena: String = binding.tvContrasena.text.toString()
        val email: String = binding.tvEmail.text.toString()
        val usuario = UsuarioEntity(0,nombre,contrasena,email);
        val usuarioDao = database.usuarioDao()


        CoroutineScope(Dispatchers.IO).launch {
            usuarioDao.insert(usuario)
        }

    }

}