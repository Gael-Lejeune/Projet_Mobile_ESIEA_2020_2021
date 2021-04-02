package com.example.projetmobile.presentation.api

import com.example.projetmobile.presentation.list.PC

class PCResponse (
    val count: Int,
    val next: String,
    val results: List<PC>
    )