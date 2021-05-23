package com.example.projetmobile.presentation.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("Name") val name: String,
    @SerializedName("BaseDamage") val damage: String,
    @SerializedName("MoveType") val moveType: String
)