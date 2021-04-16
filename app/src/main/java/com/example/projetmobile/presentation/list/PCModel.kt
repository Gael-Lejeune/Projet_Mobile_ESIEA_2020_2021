package com.example.projetmobile.presentation.list

sealed class PCModel

data class PCSuccess(val pcList: List<PC>) : PCModel()
object PCLoader : PCModel()
object PCError : PCModel()
