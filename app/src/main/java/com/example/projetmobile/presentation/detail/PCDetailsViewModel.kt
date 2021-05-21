package com.example.projetmobile.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetmobile.presentation.ApiConnector
import com.example.projetmobile.presentation.list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PCDetailsViewModel(pc: PC): ViewModel() {

    val moveList: MutableLiveData<MoveModel> = MutableLiveData()

    init {
        callApi(pc)
    }

    private fun callApi(pc: PC) {
        moveList.value = MoveLoader
        ApiConnector.pcApi.getPCMoves(pc.name).enqueue(object: Callback<List<Move>> {
            override fun onResponse(call: Call<List<Move>>, response: Response<List<Move>>) {
                if (response.isSuccessful){
                    val moveResponse = response.body()
                    if (moveResponse != null) {
                        moveList.value = MoveSuccess(moveResponse)
                    }
                } else {
                    moveList.value = MoveError
                }
            }

            override fun onFailure(call: Call<List<Move>>, t: Throwable) {
                moveList.value = MoveError
            }
        })
    }
}