package com.example.test.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test.R
import com.example.test.databinding.FragmentProfileBinding
import com.example.test.repositories.SharedPreferencesRepository
import com.example.test.ui.StartFragment
import com.example.test.ui.item.ItemBottomDialog
import com.example.test.ui.listnote.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private val viewModel: ListViewModel by viewModels()


    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.collNote.text = viewModel.getCollNotes().toString()


        view.run {
            val buttonDeleteNotes: Button = view.findViewById(R.id.delete_notes)
            buttonDeleteNotes.setOnClickListener {
                ItemBottomDialog().show(childFragmentManager, "")
            }

            val buttonLogout: Button = view.findViewById<Button>(R.id.logout)
            buttonLogout.setOnClickListener {

                val sharedPreferencesRepository = SharedPreferencesRepository(requireContext())
                sharedPreferencesRepository.logout()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, StartFragment())
                    .commit()

            }
        }
    }
}