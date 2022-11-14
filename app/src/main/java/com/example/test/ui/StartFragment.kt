package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.databinding.FragmentStartProgramBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartProgramBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDiscoverThePlatform.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FindProjectFragment())
                .commit()

            Thread {
                try {
                    Thread.sleep(2000)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, MakeMoneyFragment())
                        .commit()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }.start()

            Thread {
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().replace(R.id.container, ChatWithOtherFragment())
                    .commit()
            }.start()

            Thread {
                try {
                    Thread.sleep(8000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().replace(R.id.container, HardWorkFragment())
                    .commit()
            }.start()

            Thread {
                try {
                    Thread.sleep(11000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().replace(R.id.container, EnjoyFragment())
                    .commit()
            }.start()
        }

        binding.haveAccountLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .commit()
        }
    }

}