package com.example.proyectorecu.Clases

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Usuario::class], version = 1, exportSchema = false)
public abstract class UsuarioRoomDatabase : RoomDatabase() {

    abstract fun miUsuarioDao(): UsuarioDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                   /* var usuarioDao = database.miUsuarioDao()

                    // Delete all content here.
                    usuarioDao.deleteAll()

                    var usuario = Usuario(
                        1,
                        "Raul",
                        "12345",

                        )
                    usuarioDao.insert(usuario)
                    usuario = Usuario(
                        2,
                        "Marro",
                        "12345",

                        )
                    usuarioDao.insert(usuario)*/
                }
            }
        }
    }
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PeliculaRoomDatabase? = null

        //getDatabase returns the singleton. It'll create the database the
        //first time it's accessed, using Room's database builder to create
        //a RoomDatabase object in the application context from the WordRoomDatabase
        //class and names it "libro_database".
        fun getDatabase(context: Context, scope: CoroutineScope): PeliculaRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeliculaRoomDatabase::class.java,
                    "libro_database"
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}