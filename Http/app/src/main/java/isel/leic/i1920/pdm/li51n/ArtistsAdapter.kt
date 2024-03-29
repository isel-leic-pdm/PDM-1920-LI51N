package isel.leic.i1920.pdm.li51n

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import isel.leic.i1920.pdm.li51n.viewmodel.ArtistsViewModel

const val ARTIST_MBID = "ARTIST_MBID"
const val ARTIST_NAME = "ARTIST_NAME"

class ArtistsAdapter(val model: ArtistsViewModel)
    : RecyclerView.Adapter<ArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        // 1. Obter o TextView i.e. artist_view
        // 2. Inflate parent com o artist_view
        // 3. Instanciar ViewHolder -> passando-lhe o TextView
        val artistsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.artist_view, parent, false) as LinearLayout
        return ArtistViewHolder(artistsView)
    }

    override fun getItemCount(): Int = model.artists.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bindTo(model.artists[position])
    }
}

class ArtistViewHolder(private val view: LinearLayout) : RecyclerView.ViewHolder(view) {
    private lateinit var artist: ArtistDto
    private val txtArtistName: TextView = view.findViewById<TextView>(R.id.txtArtistName)
    private val txtArtistUrl: TextView = view.findViewById<TextView>(R.id.txtArtistUrl)

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, AlbumsActivity::class.java)
            intent.putExtra(ARTIST_MBID, artist.mbid)
            intent.putExtra(ARTIST_NAME, artist.name)
            view.context.startActivity(intent)
        }
    }

    fun bindTo(artist: ArtistDto) {
        this.artist = artist
        txtArtistName.text = artist.name
        txtArtistUrl.text = artist.url
    }
}
