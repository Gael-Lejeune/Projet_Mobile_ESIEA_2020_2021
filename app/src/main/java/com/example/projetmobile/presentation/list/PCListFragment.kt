package com.example.projetmobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R

class PCListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = PCAdapter(listOf())
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

        val pclist = arrayListOf<PC>().apply {
            add(PC("Mario"))
            add(PC("Donkey Kong"))
            add(PC("Link"))
            add(PC("Samus"))
            add(PC("Dark Samus"))
        }

        adapter.updateList(pclist)

    }

}