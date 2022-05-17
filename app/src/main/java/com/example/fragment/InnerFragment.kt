package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.BundleCompat
import androidx.fragment.app.Fragment

class InnerFragment : Fragment(R.layout.fragment_inner) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.inner_text)
        text.text = "${text.text} ${arguments?.getInt(ARG_VALUE)}"
    }

    companion object {

        private const val ARG_VALUE = "value"

        fun create(value: Int) : InnerFragment {
            val fragment = InnerFragment()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, value)
            fragment.arguments = arguments
            return fragment
        }
    }
}
