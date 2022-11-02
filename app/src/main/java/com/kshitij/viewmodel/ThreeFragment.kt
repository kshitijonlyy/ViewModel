package com.kshitij.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kshitij.viewmodel.databinding.FragmentThreeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThreeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentThreeBinding
    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThreeBinding.inflate((layoutInflater))
        mainActivity = activity as MainActivity

        mainActivity.liveColorChangeViewModel.color.observe(mainActivity) {
            when (it) {
                0 -> binding.threeFragment.setBackgroundColor(
                    ContextCompat.getColor(mainActivity, android.R.color.white)
                )
                1 -> binding.threeFragment.setBackgroundColor(
                    ContextCompat.getColor(mainActivity, android.R.color.holo_blue_dark)
                )
                2 -> binding.threeFragment.setBackgroundColor(
                    ContextCompat.getColor(mainActivity, android.R.color.holo_red_dark)
                )
                3 -> binding.threeFragment.setBackgroundColor(
                    ContextCompat.getColor(mainActivity, android.R.color.holo_green_dark)
                )
            }
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThreeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThreeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}