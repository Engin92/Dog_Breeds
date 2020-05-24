package com.example.Breedlist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.Breedlist.network.response.CurrentBreedResponseItem


@Database(
    entities = [(CurrentBreedResponseItem::class)],
    version = 1
)
abstract class BreedDatabase : RoomDatabase() {
    abstract fun currentBreedDao(): CurrentBreedDao

}
