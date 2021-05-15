package com.example.projetmobile.presentation.detail

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.projetmobile.R
import com.example.projetmobile.presentation.list.PC
import com.google.gson.Gson

class PCDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewmoves: TextView
    private lateinit var pcImage: ImageView
    private lateinit var backButton: Button
    private lateinit var notifButton: Button

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
        textViewmoves = view.findViewById(R.id.pc_moves)
        pcImage = view.findViewById(R.id.pc_detail_image)
        val jsonPC = arguments?.getString(KEY_JSON)
        val pc = Gson().fromJson(jsonPC, PC::class.java)
        view.setBackgroundColor(Color.parseColor(pc.colorTheme))
        textViewName.text = pc.name
        //textViewmoves.text = pc.moves[0]
        //println(pc.moves)

        Glide
            .with(view.context)
            .load(pc.image)
            .fitCenter()
            .into(pcImage)

        backButton = view.findViewById(R.id.button_list)
        backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        /*
        notifButton = view.findViewById(R.id.pc_notif)
        notifButton.setOnClickListener {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "main"
                val descriptionText = "main notification channel"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("main", name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }


            var builder = NotificationCompat.Builder(view.context, "main")
                .setSmallIcon(R.drawable.smashlogo)
                .setContentTitle("This the "+ pc.name +" notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(view.context)) {
                // notificationId is a unique int for each notification that you must define
                notify(1, builder.build())
            }
        }*/
    }

    companion object {
        const val KEY_JSON = "KEY_JSON"
    }



}