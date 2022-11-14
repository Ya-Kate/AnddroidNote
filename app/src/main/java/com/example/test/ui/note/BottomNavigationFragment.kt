package com.example.test.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.databinding.FragmentBottomNavigationBinding
import com.example.test.ui.addnote.AddNoteFragment
import com.example.test.ui.listnote.ListFragment

private lateinit var binding: FragmentBottomNavigationBinding

class BottomNavigationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBottomNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> {
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, ListFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.search -> {
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, SearchFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.message -> {
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, AddNoteFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.profiles -> {
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, Profile())
                        .addToBackStack("")
                        .commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}