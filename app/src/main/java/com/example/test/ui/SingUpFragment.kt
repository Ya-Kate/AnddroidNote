package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.ui.listnote.ListFragment
import com.google.android.material.textfield.TextInputLayout

class SingUpFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sing_up,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var textInputFirstName: String
        var textInputLastName: String
        var textInputEmail: String
        var textInputPassword: String
        var toast: Toast
        val minColInputChar = 5

//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_up)

        val buttonEnterLogin: Button = view.findViewById<Button>(R.id.enter_login)
        buttonEnterLogin.setOnClickListener {
            parentFragmentManager.beginTransaction().
            replace(R.id.container, LogInFragment() )
                .addToBackStack("")
                .commit()
        }

        val buttonSignUp: Button = view.findViewById<Button>(R.id.button_sign_up07)
        buttonSignUp.setOnClickListener {

            val firstName = view.findViewById<TextInputLayout>(R.id.firstName)
            textInputFirstName = firstName.editText?.text.toString()

            val lastName = view.findViewById<TextInputLayout>(R.id.lastName)
            textInputLastName = lastName.editText?.text.toString()

            val email = view.findViewById<TextInputLayout>(R.id.email)
            textInputEmail = email.editText?.text.toString()
            val isExist = "@" in textInputEmail

            val password = view.findViewById<TextInputLayout>(R.id.password)
            textInputPassword = password.editText?.text.toString()

            if (isExist == false) {
                toast = Toast.makeText(
                    activity,
                    "email mast contain '@'",
                    Toast.LENGTH_LONG
                )
                toast.show()

            } else if (textInputEmail.length <= minColInputChar || textInputPassword.length <= minColInputChar || textInputFirstName.length == 0 || textInputLastName.length == 0) {
                toast = Toast.makeText(activity, "Add correct data", Toast.LENGTH_LONG)
                toast.show()
            } else {
                parentFragmentManager.beginTransaction().
                replace(R.id.container, ListFragment() )
                    .addToBackStack("")
                    .commit()
            }
        }
    }
}