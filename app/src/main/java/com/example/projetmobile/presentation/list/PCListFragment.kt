package com.example.projetmobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.MainActivity
import com.example.projetmobile.R
import com.example.projetmobile.presentation.ApiConnector
import com.example.projetmobile.presentation.api.PCApi
import com.example.projetmobile.presentation.detail.PCDetailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PCListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var error: TextView

    private val adapter = PCAdapter(listOf(), ::navigateToPCDetailFragment)
    private lateinit var viewModel: PCListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(com.example.projetmobile.presentation.list.PCListViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pc_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.pc_recyclerview)
        loader = view.findViewById(R.id.pc_loader)
        error = view.findViewById(R.id.pc_error_text)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PCListFragment.adapter
        }

        viewModel.pcList.observe(viewLifecycleOwner, Observer { pcModel ->
            loader.isVisible = pcModel is PCLoader
            error.isVisible = pcModel is PCError
            if (pcModel is PCSuccess){
                adapter.updateList(pcModel.pcList)
            }
        })
    }

    private fun navigateToPCDetailFragment(pc: PC) {
        (activity as MainActivity).navigateToPCDetailFragment(pc)
    }

}


