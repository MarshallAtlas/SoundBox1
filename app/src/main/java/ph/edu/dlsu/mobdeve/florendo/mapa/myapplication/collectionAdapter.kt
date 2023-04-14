package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.CollectionLayoutBinding
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.collection

class collectionAdapter(private val context: Context, private val collections: MutableList<collection>) : RecyclerView.Adapter<collectionAdapter.CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val binding = CollectionLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val collection = collections[position]
        holder.bind(collection)
    }

    override fun getItemCount() = collections.size

    inner class CollectionViewHolder(private val binding: CollectionLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(collection: collection) {
            binding.collectionName.text = collection.cname
        }
    }

    fun addCollection(newCollection: collection) {
        collections.add(newCollection)
        notifyItemInserted(collections.size - 1)
    }

    fun deleteCollection(position: Int){
        collections.removeAt(position)
        notifyItemRemoved(position)
    }
}
