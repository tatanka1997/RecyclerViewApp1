package com.android.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewapp.R
import com.android.recyclerviewapp.adapter.EventAdapter
import com.android.recyclerviewapp.adapter.Tofragment3
import com.android.recyclerviewapp.databinding.FragmentFirstBinding
import com.android.recyclerviewapp.fragmentNavigation
import com.android.recyclerviewapp.model.Event

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(), Tofragment3{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private var counter = 0

    // This is my adapter to be used to change the data
    private val eventAdapter by lazy {
        EventAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           val event= it.getParcelable<Event>("myEvent")
            if (event !=null){
                eventAdapter.updateEventData(event)
            }
            setRetainInstance(true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter
        }

        binding.addEvent.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance("", "")
            )
        }

        return binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(newEvent: Event? = null) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("myEvent", newEvent)
                }
            }
    }

    override fun onFragmentClick(event: Event) {
        fragmentNavigation(
            supportFragmentManager = requireActivity().supportFragmentManager,
            ThirdFragment.newInstance(event)
        )
    }
}