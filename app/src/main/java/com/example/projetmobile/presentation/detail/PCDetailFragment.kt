package com.example.projetmobile.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetmobile.R
import com.example.projetmobile.presentation.list.PC
import com.google.gson.Gson


class PCDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var pcImage: ImageView
    private lateinit var backButton: Button
    private lateinit var recyclerView: RecyclerView

    private val adapter = MoveAdapter(listOf())

    private lateinit var loader: ProgressBar
    private lateinit var error: TextView
    private lateinit var viewModel: PCDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pc_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonPC = arguments?.getString(KEY_JSON)
        val pc = Gson().fromJson(jsonPC, PC::class.java)
        viewModel = ViewModelProvider(
            this,
            MoveModelFactory(pc!!)
        ).get(
            PCDetailsViewModel::class.java
        )

        recyclerView = view.findViewById(R.id.pc_moves)
        loader = view.findViewById(R.id.move_loader)
        error = view.findViewById(R.id.move_error_text)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PCDetailFragment.adapter
        }

        viewModel.moveList.observe(viewLifecycleOwner, Observer { moveModel ->
            loader.isVisible = moveModel is MoveLoader
            error.isVisible = moveModel is MoveError
            if (moveModel is MoveSuccess){
                println(moveModel.moveList)
                pc.moves = moveModel.moveList
                adapter.updateList(pc.moves)
            }
        })

        textViewName = view.findViewById(R.id.pc_detail_name)
        pcImage = view.findViewById(R.id.pc_detail_image)
        view.setBackgroundColor(Color.parseColor(pc.colorTheme))
        textViewName.text = pc.displayName


        Glide
            .with(view.context)
            .load(pc.image)
            .fitCenter()
            .into(pcImage)

        backButton = view.findViewById(R.id.button_list)
        backButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    companion object {
        const val KEY_JSON = "KEY_JSON"
    }



}