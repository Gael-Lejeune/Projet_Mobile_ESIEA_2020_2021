package com.example.projetmobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R
import com.example.projetmobile.presentation.api.PCApi
import com.example.projetmobile.presentation.api.PCResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PCListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = PCAdapter(listOf(), ::navigateToPCDetailFragment)
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pc_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         recyclerView = view.findViewById(R.id.pc_recyclerview)

        recyclerView.apply {
            layoutManager = this@PCListFragment.layoutManager
            adapter = this@PCListFragment.adapter
        }

        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val pcApi: PCApi = retrofit.create(PCApi::class.java)

        pcApi.getPCList().enqueue(object: Callback<PCResponse>{
            override fun onResponse(call: Call<PCResponse>, response: Response<PCResponse>) {
                if (response.isSuccessful){
                    val pcResponse = response.body()
                    if (pcResponse != null) {
                        adapter.updateList(pcResponse.results)
                    }
                }
            }

            override fun onFailure(call: Call<PCResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun navigateToPCDetailFragment(pc: PC) {
        childFragmentManager.beginTransaction()
            .replace(R.id.container, PCDetailFragment(), "")
            .addToBackStack(null)
            .commit()
    }

}


