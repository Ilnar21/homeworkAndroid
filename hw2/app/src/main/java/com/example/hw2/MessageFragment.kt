package com.example.hw2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class MessageFragment : Fragment(R.layout.fragment_message) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.editText)
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val inputText = editText.text.toString()
            if (inputText.isEmpty()) {
                Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle().apply {
                    putString("inputText", inputText)
                }
                findNavController().navigate(R.id.action_messageFragment_to_displayFragment, bundle)
            }
        }
    }
}
