package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.AlbumlayoutBinding
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.album

class albumAdapter(private val context: Context, private val albums: MutableList<album>) : RecyclerView.Adapter<albumAdapter.albumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): albumViewHolder {
        val binding = AlbumlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return albumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: albumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount() = albums.size

    inner class albumViewHolder(private val binding: AlbumlayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: album) {
            binding.albumName.text = album.name
            binding.albumArtist.text = album.artist


            // delete an album when clicked
            binding.albumName.setOnClickListener{
                deleteAlbum(adapterPosition)
            }

        }
    }

    fun addAlbum(newAlbum: album) {
        albums.add(newAlbum)
        notifyItemInserted(albums.size - 1)
    }

    fun deleteAlbum(position: Int){
        albums.removeAt(position)
        notifyItemRemoved(position)
    }


}
