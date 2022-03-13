package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.databinding.FragmentThirdBinding
import com.android.recyclerviewapp.model.Event
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class ThirdFragment : Fragment() {

    private val binding by lazy{
        FragmentThirdBinding.inflate(layoutInflater)
    }
   private lateinit var event: Event
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
         event= it.getParcelable("event")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.eventTitleEt.text=event.title
        binding.eventCategoryEt.text=event.category
        val eventKoha= SimpleDateFormat("yyyy/M/dd").parse(event.date).time
        binding.daysleft.text= ((eventKoha-binding.eventCalendar.date)/86400000+1).toString()+" days left"
        binding.eventCalendar.date=eventKoha
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(event: Event?=null) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("event",event)
                }
            }
    }
}