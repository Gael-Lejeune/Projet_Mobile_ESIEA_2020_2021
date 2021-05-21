package com.example.projetmobile.presentation.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetmobile.presentation.list.PC


class MoveModelFactory(private val mParam: PC) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PCDetailsViewModel(mParam) as T
        }

}