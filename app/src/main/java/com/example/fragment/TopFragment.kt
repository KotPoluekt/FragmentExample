package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TopFragment : Fragment() {

    var counter = 1
    lateinit var host: Host

    override fun onAttach(context: Context) {
        super.onAttach(context)

        host = context as? Host ?: error("No  implemented host")

        Log.d("Tomato", "TopFragment.onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Tomato", "TopFragment.onCreateView")
        return inflater.inflate(R.layout.fragment_top, container, false )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Tomato", "TopFragment.onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.create(counter))
                .addToBackStack("fragment$counter")
                .commit()


            // Отправить результат в нижний фрагмент
            val bundle = Bundle()
            bundle.putInt("value", counter)
            parentFragmentManager.setFragmentResult("top_result", bundle)

            // Отправить результат в активити дедовским способом
            host.onCountIncremented(counter)

            counter++
        }

        view.findViewById<Button>(R.id.btn_delete_bottom_fragment).setOnClickListener{
            if (childFragmentManager.backStackEntryCount > 0) {
                //childFragmentManager.popBackStack("fragment2", 0)
                childFragmentManager.popBackStack()
            } else {
                host.closeActivity()
            }
        }
    }

    interface Host {
        fun onCountIncremented(count: Int)
        fun closeActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Tomato", "TopFragment.onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Tomato", "TopFragment.onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Tomato", "TopFragment.onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Tomato", "TopFragment.onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Tomato", "TopFragment.onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Tomato", "TopFragment.onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Tomato", "TopFragment.onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Tomato", "TopFragment.onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Tomato", "TopFragment.onDetach")
        super.onDetach()
    }
}