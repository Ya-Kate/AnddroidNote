package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.databinding.FragmentLogInBinding
import com.example.test.repositories.SharedPreferencesRepository
import com.example.test.ui.listnote.ListFragment
import com.example.test.ui.note.BottomNavigationFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    private lateinit var toast: Toast

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.firstName.text = sharedPreferencesRepository.getUserName()

//      binding.password21.editText?.text = sharedPreferencesRepository.getUserPassword()

        val returnSign: Button = binding.returnSign
        returnSign.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SingUpFragment())
                .addToBackStack("")
                .commit()
        }

        val buttonLogIn: Button = binding.buttonLogIn21
        buttonLogIn.setOnClickListener {
            if (binding.textInputPassword.text.toString() == sharedPreferencesRepository.getUserPassword()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, BottomNavigationFragment())
                    .commit()
                parentFragmentManager.beginTransaction()
                    .add(R.id.container, ListFragment())
                    .commit()

            } else {
                toast = Toast.makeText(activity, "in correct password", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}