package com.example.Breedlist.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.Breedlist.network.response.CurrentBreedResponseItem

@Dao
interface CurrentBreedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(breedResponseItem: CurrentBreedResponseItem)

}