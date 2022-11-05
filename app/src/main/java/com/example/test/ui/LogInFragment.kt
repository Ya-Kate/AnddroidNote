package com.example.test.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.ui.listnote.ListFragment
import com.google.android.material.textfield.TextInputLayout

class LogInFragment:Fragment() {
    lateinit var textInputEmail: String
    lateinit var textInputLogin: String
    lateinit var toast: Toast
    val colInputChar = 5

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragmrnt_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val returnSign: Button = view.findViewById<Button>(R.id.return_sign)
        returnSign.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SingUpFragment())
                .addToBackStack("")
                .commit()
        }


        val buttonLogIn: Button = view.findViewById<Button>(R.id.button_log_in21)
        buttonLogIn.setOnClickListener {


            val login = view.findViewById<TextInputLayout>(R.id.password21)
            textInputLogin = login.editText?.text.toString()

            val email = view.findViewById<TextInputLayout>(R.id.email21)
            textInputEmail = email.editText?.text.toString()
            val isExist = "@" in textInputEmail

            if (isExist == false) {
                toast = Toast.makeText(
                    activity,
                    "email mast contain '@'",
                    Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()

            } else if (textInputLogin.length <= colInputChar || textInputEmail.length <= colInputChar) {

                toast = Toast.makeText(
                    activity,
                    "wrong password or email",
                    Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment())
                    .commit()
            }
        }

    }
}