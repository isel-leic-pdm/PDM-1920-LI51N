package isel.leic.i1920.pdm.li51n

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.dto.AlbumDto

class AlbumsAdapter(private val albums: List<AlbumDto>)
    : RecyclerView.Adapter<AlbumViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_view, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindTo(albums[position])
    }
}

class AlbumViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val txtAlbumName: TextView = view.findViewById<TextView>(R.id.txtAlbumName)
    private val txtPlaycount: TextView = view.findViewById<TextView>(R.id.txtPlaycount)

    fun bindTo(album: AlbumDto) {
        txtAlbumName.text = album.name
        txtPlaycount.text = "Playcount: " + album.playcount
    }
}
