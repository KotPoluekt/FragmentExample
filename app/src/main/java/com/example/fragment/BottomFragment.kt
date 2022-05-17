package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class BottomFragment : Fragment(R.layout.fragment_bottom) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.bottom_title)

        parentFragmentManager.setFragmentResultListener(
            "top_result",
            this
        ) { _, result ->
            text.text = "I am BOTTOM fragment. Value = ${result.getInt("value")}"
        }
    }
}