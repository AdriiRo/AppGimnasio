package es.etg.dam.pmdmARO.gym

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.dam.pmdmARO.gym.data.UsuarioDatabase
import es.etg.dam.pmdmARO.gym.data.UsuarioEntity
import es.etg.dam.pmdmARO.gym.databinding.ActivityRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    companion object {
        lateinit var database: UsuarioDatabase
        const val DATABASE_NAME = "usuario-db"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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