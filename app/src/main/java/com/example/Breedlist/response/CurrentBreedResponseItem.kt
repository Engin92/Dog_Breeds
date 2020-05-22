package com.example.Breedlist.response


import com.google.gson.annotations.SerializedName

data class CurrentBreedResponseItem(
    @SerializedName("bred_for")
    val bredFor: String,
    val height: Height,
    val id: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val weight: Weight
)