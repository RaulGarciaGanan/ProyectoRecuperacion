package com.example.proyectorecu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toolbar
import androidx.activity.viewModels
import com.example.proyectorecu.Clases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

import java.util.logging.Level.parse
import kotlin.time.Duration.Companion.parse


class MainActivity : AppCompatActivity() {

    val mainActivityScope = CoroutineScope(SupervisorJob())

    val miViewModel: VM by viewModels()

    private val database by lazy {PeliculaRoomDatabase.getDatabase(this, mainActivityScope)}
    private val database2 by lazy { UsuarioRoomDatabase.getDatabase(this, mainActivityScope)}
    private val miRepositorio by lazy { PeliculaRepository(database.miPeliculaDao()) }
    //private val miRepositorio2 by lazy { UsuarioRoomDatabase(database2.miUsuarioDao()) }
    val miViewModel2: PeliculaViewModel by viewModels {PeliculaViewModel.PeliculaViewModelFactory(miRepositorio)}
    //val miViewModel3: UsuarioViewModel by viewModels {UsuarioViewModel.UsuarioViewModelFactory(miRepositorio2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.mytoolbar))


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.itBiblioteca -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}





