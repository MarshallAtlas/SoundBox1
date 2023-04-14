package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.fragments

import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.collection
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.R
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.collectionAdapter
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.FragmentAccountBinding
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.FragmentDashBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var param1: String? = null
private var param2: String? = null

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





class accountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    // TODO: Rename and change types of parameters
    private var collectionAdapter: collectionAdapter? = null

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

        binding = FragmentAccountBinding.inflate(inflater, container, false)

        binding.accountCollectionList.layoutManager = LinearLayoutManager(requireActivity().applicationContext,
            LinearLayoutManager.VERTICAL, // this determines orientation
            false)
        collectionAdapter = collectionAdapter(requireActivity().applicationContext, getCollection())
        binding.accountCollectionList.adapter = collectionAdapter

        return binding.root
    }

    private fun getCollection() = ArrayList<collection>().apply {
        add(collection("My Collection1"))
        add(collection("My Collection2"))
        add(collection("My Collection3"))
        add(collection("My Collection4"))
    }

}