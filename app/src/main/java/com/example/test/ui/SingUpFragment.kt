package com.example.test.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.databinding.FragmentSingUpBinding
import com.example.test.validation.Invalid
import com.example.test.validation.validateEmail
import com.example.test.validation.validatePassword

import com.example.test.repositories.SharedPreferencesRepository
import com.example.test.ui.listnote.ListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingUpFragment : Fragment() {

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

     lateinit var binding: FragmentSingUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var toast: Toast

        binding.enterLogin.setOnClickListener {
            if (sharedPreferencesRepository.getUserName() == null) {
                toast = Toast.makeText(activity, "SING UP", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        binding.buttonSignUp07.setOnClickListener {
            val firstNameInputLayout = binding.firstName.editText?.text.toString()
            val email = binding.email.editText?.text.toString()
            val passwordInputLayout = binding.password.editText?.text.toString()

            if (firstNameInputLayout.isNotBlank() && passwordInputLayout.isNotBlank()) {
                sharedPreferencesRepository.setUserName(firstNameInputLayout)
                sharedPreferencesRepository.setUserPassword(passwordInputLayout)
                requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            } else {
                if (validate()) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ListFragment())
                        .addToBackStack("")
                        .commit()
                }
            }
        }
    }

    private fun validate(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()

        return isEmailValid == null && isPasswordValid == null
    }

    private fun validatePassword(): String? {
        val textInputPassword = binding.password
        textInputPassword.editText?.let {
            val result = validatePassword(it.text.toString())
            return when (result) {
                is Invalid -> {
                    textInputPassword.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    textInputPassword.error = null
                    null
                }
            }
        } ?: return null

    }

    private fun validateEmail(): String? {
        val textInputEmail = binding.email
        textInputEmail.editText?.let {
            val result = validateEmail(it.text.toString())
            return when (result) {
                is Invalid -> {
                    textInputEmail.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    textInputEmail.error = null
                    null
                }
            }
        } ?: return null

    }
}