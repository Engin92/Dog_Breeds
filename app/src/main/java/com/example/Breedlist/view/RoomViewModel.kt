package com.example.Breedlist.view

import android.app.Application
import androidx.room.Room
import com.example.Breedlist.database.BreedDatabase

class RoomViewModel : Application() {

    companion object {
        var database: BreedDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, BreedDatabase::class.java, "breed_db").fallbackToDestructiveMigration().build()
    }
}