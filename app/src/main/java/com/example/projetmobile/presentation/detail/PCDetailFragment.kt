package com.example.projetmobile.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projetmobile.R
import com.example.projetmobile.presentation.ApiConnector
import com.example.projetmobile.presentation.list.PC
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response

class PCDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pc_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName = view.findViewById(R.id.pc_detail_name)
        val jsonPC = arguments?.getString(KEY_JSON)
        val pc = Gson().fromJson(jsonPC, PC::class.java)
        textViewName.text = pc.name
    }

    private fun callApi() {
        ApiConnector.pcApi.getPCDetails("Mario").enqueue(object : retrofit2.Callback<PC>{
            override fun onResponse(call: Call<PC>, response: Response<PC>) {
                if (response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                }
            }

            override fun onFailure(call: Call<PC>, t: Throwable) {

            }
        })
    }

    companion object {
        const val KEY_JSON = "KEY_NAME"
    }

}