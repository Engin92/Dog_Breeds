package com.example.Breedlist.network.response


import androidx.annotation.Nullable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Breeds")
data class CurrentBreedResponseItem(
    @SerializedName("bred_for")
    val bredFor: String,
    @Embedded(prefix = "height_")
    val height: Height,
    val id: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    @PrimaryKey
    val name: String,
    val temperament: String,
    @Embedded(prefix = "weight_")
    val weight: Weight
)