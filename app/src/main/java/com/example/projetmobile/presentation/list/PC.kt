package com.example.projetmobile.presentation.list

import com.example.projetmobile.presentation.detail.Move
import com.google.gson.annotations.SerializedName

data class PC(
    @SerializedName("Name") val name: String,
    @SerializedName("DisplayName") val displayName: String,
    @SerializedName("ThumbnailUrl") val thumb: String,
    @SerializedName("MainImageUrl") val image: String,
    @SerializedName("ColorTheme") val colorTheme: String,
    @SerializedName("Game") val game: String,
    @SerializedName("Moves") var moves: List<Move>
)