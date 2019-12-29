package com.example.characterviewer.model


import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("FirstURL")
    val firstURL: String,
    @SerializedName("Icon")
    val icon: Icon,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Text")
    val text: String
)