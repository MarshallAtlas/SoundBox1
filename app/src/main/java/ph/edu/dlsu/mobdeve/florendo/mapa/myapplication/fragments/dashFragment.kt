package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.albumAdapter
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.FragmentDashBinding
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.album
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.collectionAdapter
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.dao.albumDAO
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.dao.albumDAOSQLiteImplementation
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.collection

class dashFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null


    private lateinit var binding: FragmentDashBinding
    // you make albumAdapter
    private var albumAdapter: albumAdapter? = null
    private var collectionAdapter: collectionAdapter? = null

    private lateinit var AlbumDAO: albumDAO

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
        binding = FragmentDashBinding.inflate(inflater, container, false)

    // DATABASE STUFF
        AlbumDAO = albumDAOSQLiteImplementation(requireActivity().applicationContext)



    // RECYCLER VIEW
        // you tell the adapter that each will contain layoutmanager
        binding.albumList.layoutManager = LinearLayoutManager(requireActivity().applicationContext,
            LinearLayoutManager.HORIZONTAL, // this determines orientation
            false)
        binding.collectionList.layoutManager = LinearLayoutManager(requireActivity().applicationContext,LinearLayoutManager.HORIZONTAL, false)

        // instantiate recycler view
        albumAdapter = albumAdapter(requireActivity().applicationContext, getAlbum()) // something wrong with this
        collectionAdapter = collectionAdapter(requireActivity().applicationContext, getCollection())

        binding.albumList.adapter = albumAdapter
        binding.collectionList.adapter = collectionAdapter


        return binding.root
    }

    private fun getAlbum() = ArrayList<album>().apply {
        add(album("Favorite", "Ang Bandang Shirley"))
        add(album("superclean", "The Marias"))
        add(album("BoyGenius", "BoyGenius"))
        add(album("hmmm food", "MFDOOM"))
    }

    private fun getCollection() = ArrayList<collection>().apply {
        add(collection("My Collection1"))
        add(collection("My Collection2"))
        add(collection("My Collection3"))
        add(collection("My Collection4"))
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
    }
}
