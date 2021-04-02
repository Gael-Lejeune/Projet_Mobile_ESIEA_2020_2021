package com.example.projetmobile.presentation.list

import com.google.gson.annotations.SerializedName

data class PC(
    @SerializedName("Name") val name: String,
    @SerializedName("DisplayName") val displayName: String,
    @SerializedName("ThumbnailUrl") val thumb: String,
    @SerializedName("ColorTheme") val colorTheme: String
    //val movementsURL: String
)