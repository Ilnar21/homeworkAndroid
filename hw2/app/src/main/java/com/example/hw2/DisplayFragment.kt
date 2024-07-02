package com.example.hw2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class DisplayFragment : Fragment(R.layout.fragment_display) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayText = arguments?.getString("inputText")
        val textView = view.findViewById<TextView>(R.id.displayTextView)
        textView.text = displayText
    }
}
