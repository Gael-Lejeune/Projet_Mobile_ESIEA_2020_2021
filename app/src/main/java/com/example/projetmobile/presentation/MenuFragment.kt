package com.example.projetmobile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.MainActivity
import com.example.projetmobile.R
import com.example.projetmobile.presentation.list.PCAdapter
import com.example.projetmobile.presentation.list.PCListFragment

class MenuFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = PCAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button_list)
        button.setOnClickListener {
            (activity as MainActivity).navigateToListFragment()
        }

    }

}