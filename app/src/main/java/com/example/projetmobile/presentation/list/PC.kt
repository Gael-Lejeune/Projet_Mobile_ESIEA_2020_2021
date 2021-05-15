package com.example.projetmobile.presentation.list

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PC(
    @SerializedName("Name") val name: String,
    @SerializedName("DisplayName") val displayName: String,
    @SerializedName("ThumbnailUrl") val thumb: String,
    @SerializedName("MainImageUrl") val image: String,
    @SerializedName("ColorTheme") val colorTheme: String,
    @SerializedName("Moves") val moves: List<String>
//val movementsURL: String
)