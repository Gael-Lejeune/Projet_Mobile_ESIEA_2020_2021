package com.example.projetmobile.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetmobile.R

class PCAdapter(private var dataSet: List<PC>,var listener: ((PC) -> Unit)? = null
) :RecyclerView.Adapter<PCAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.pc_name)
            imageView = view.findViewById(R.id.pc_image)
        }
    }

    fun updateList(list: List<PC>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pc_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val pc = dataSet[position]
        viewHolder.textView.text = pc.displayName
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(pc)
        }


        Glide
            .with(viewHolder.itemView.context)
            .load(pc.thumb)
            .centerCrop()
            .into(viewHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}