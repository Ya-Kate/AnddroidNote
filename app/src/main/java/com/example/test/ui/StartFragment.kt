package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.test.R

class StartFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start_program,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_discover_the_platform).setOnClickListener{
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentTwo() )
            .commit()

            Thread {
                try {
                    Thread.sleep(2000)
                    parentFragmentManager.beginTransaction().
                    replace(R.id.container, FragmentThree() )
                        .commit()
                } catch (e: InterruptedException) {
                    var ff = 22222
                    e.printStackTrace()
                }

            }.start()

            Thread {
                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().
                replace(R.id.container, FragmentFour() )
                    .commit()
            }.start()

            Thread {
                try {
                    Thread.sleep(8000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().
                replace(R.id.container, FragmentFive() )
                    .commit()
            }.start()

            Thread {
                try {
                    Thread.sleep(11000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                parentFragmentManager.beginTransaction().
                replace(R.id.container, FragmentSix() )
                    .commit()
            }.start()
        }

        view.findViewById<Button>(R.id.have_account_login).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .addToBackStack("")
                .commit()
        }
    }

}