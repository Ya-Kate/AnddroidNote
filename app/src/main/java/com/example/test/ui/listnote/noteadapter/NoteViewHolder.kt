package com.example.test.ui.listnote.noteadapter

import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ItemNoteBinding
import com.example.test.model.Note
import com.example.test.util.DateConverter
import com.example.test.util.convertToSimpleDate
import java.util.*

class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    private val dateConvector = DateConverter()

    fun bind(note: Note) {

        val dateString = note.nowData

        val curTime: Long = Date().getTime()

        binding.title.text = note.title
        binding.message.text = note.message
        binding.dates.text = dateConvector.dateFromLong(dateString).convertToSimpleDate()

        val cmp = dateString.compareTo(curTime)
        when {
            cmp > 0 -> {
                binding.root.setBackgroundColor(
                    binding.root.rootView.resources.getColor(
                        R.color.item_note_today
                    )
                )
            }
            cmp < 0 -> {
                binding.root.setBackgroundColor(
                    binding.root.rootView.resources.getColor(
                        R.color.teal_200
                    )
                )
            }
        }
    }

}