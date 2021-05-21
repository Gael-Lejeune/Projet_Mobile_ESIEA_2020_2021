package com.example.projetmobile.presentation.detail

sealed class MoveModel

data class MoveSuccess(val moveList: List<Move>) : MoveModel()
object MoveLoader : MoveModel()
object MoveError : MoveModel()
