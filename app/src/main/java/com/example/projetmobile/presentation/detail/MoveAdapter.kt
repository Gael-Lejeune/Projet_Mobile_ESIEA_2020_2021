package com.example.projetmobile.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R

class MoveAdapter(private var dataSet: List<Move>) :RecyclerView.Adapter<MoveAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val typeTextView: TextView
        val damageTextView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            nameTextView = view.findViewById(R.id.move_name)
            typeTextView = view.findViewById(R.id.move_type)
            damageTextView = view.findViewById(R.id.move_damage)

        }
    }

    fun updateList(list: List<Move>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.move_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val move = dataSet[position]
        viewHolder.nameTextView.text = move.name
        viewHolder.typeTextView.text = move.moveType
        viewHolder.damageTextView.text = move.damage

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}