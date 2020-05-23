package com.example.Breedlist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.Breedlist.network.response.CurrentBreedResponseItem


@Database(
    entities = [CurrentBreedResponseItem::class],
    version = 1
)
abstract class BreedDatabase : RoomDatabase() {
    abstract fun currentBreedDao(): CurrentBreedDao

}
    /*
    //RoomViewModelKotlinSample
    companion object {
        @Volatile private var instance: BreedDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                BreedDatabase::class.java, "breed.db")
                .build()
    }

     */
