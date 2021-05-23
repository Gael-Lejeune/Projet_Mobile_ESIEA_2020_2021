package com.example.projetmobile.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetmobile.presentation.ApiConnector
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PCListViewModel: ViewModel() {

    val pcList: MutableLiveData<PCModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pcList.value = PCLoader
        ApiConnector.pcApi.getPCList().enqueue(object: Callback<List<PC>> {
            override fun onResponse(call: Call<List<PC>>, response: Response<List<PC>>) {
                if (response.isSuccessful){
                    val pcResponse = response.body()
                    if (pcResponse != null) {
                        pcList.value = PCSuccess(pcResponse)
                    }
                } else {
                    pcList.value = PCError
                }
            }

            override fun onFailure(call: Call<List<PC>>, t: Throwable) {
                pcList.value = PCError
            }
        })
    }
}