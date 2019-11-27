package isel.leic.i1920.pdm.li51n

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
            .inflate(R.layout.artist_view, parent, false)
        return ArtistViewHolder(artistsView)
    }

    override fun getItemCount(): Int = model.artists.value?.size ?: 0

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        model.artists.value?.get(position)?.let { holder.bindTo(it) }
    }
}

class ArtistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var artist: ArtistDto
    private val txtArtistName: TextView = view.findViewById(R.id.txtArtistName)
    private val txtArtistUrl: TextView = view.findViewById(R.id.txtArtistUrl)
    private val artistImage: ImageView = view.findViewById(R.id.artistImage)

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
        Log.i(TAG, "Image url ${artist.image[0].uri}")
        Glide.with(view.context).load(artist.image[0].uri).override(120).into(artistImage);
    }
}
