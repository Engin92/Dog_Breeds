package com.example.Breedlist.network.response


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.Breedlist.database.entity.Height
import com.example.Breedlist.database.entity.Weight
import com.google.gson.annotations.SerializedName

@Entity(tableName = "current_breed")
data class CurrentBreedResponseItem(
    @SerializedName("bred_for")
    val bredFor: String,
    @Embedded(prefix = "height_")
    val height: Height,
    val id: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    val name: String,
    val origin: String,
    val temperament: String,
    @Embedded(prefix = "weight_")
    val weight: Weight
) {
    @PrimaryKey(autoGenerate = false)
    var idPrimary: Int = id
}