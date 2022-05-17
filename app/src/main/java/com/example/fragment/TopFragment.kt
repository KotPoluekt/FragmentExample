package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TopFragment : Fragment() {

    var counter = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top, container, false )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.create(counter))
                .addToBackStack("fragment$counter")
                .commit()
            counter++
        }

        view.findViewById<Button>(R.id.btn_delete_bottom_fragment).setOnClickListener{
            childFragmentManager.popBackStack("fragment2", 0)
        }
    }
}