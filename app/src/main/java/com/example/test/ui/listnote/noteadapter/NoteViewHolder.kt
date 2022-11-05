package com.example.test.ui.listnote.noteadapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteViewHolder( val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(note: Note) {
        val dateString = note.nowData
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val dateNote = formatter.parse(dateString)
        val dataStringNow = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
        val dataNow = formatter.parse(dataStringNow)

        view.findViewById<TextView>(R.id.title).text = note.title
        view.findViewById<TextView>(R.id.message).text = note.message
        view.findViewById<TextView>(R.id.time).text = note.nowData

        val cmp = dateNote.compareTo(dataNow)
        when {
            cmp > 0 -> {
                view.setBackgroundColor(view.rootView.resources.getColor(
                    R.color.item_note_today
                ))
            }
            cmp < 0 -> {
                view.setBackgroundColor(view.rootView.resources.getColor(
                    R.color.teal_200
                ))
            }
            cmp == 0 -> {

            }
        }
    }

}