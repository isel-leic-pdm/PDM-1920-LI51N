package isel.leic.i1920.pdm.li51n

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto

const val ARTIST_MBID = "ARTIST_MBID"
const val ARTIST_NAME = "ARTIST_NAME"

class ArtistsAdapter(private val artists: Array<ArtistDto>)
    : RecyclerView.Adapter<ArtistViewHolder>()
{
    val TAG = ArtistsAdapter::class.java.name

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {

        Log.i(TAG, "onCreateViewHolder called")

        // 1. Obter o TextView i.e. artist_view
        // 2. Inflate parent com o artist_view
        // 3. Instanciar ViewHolder -> passando-lhe o TextView
        val artistsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.artist_view, parent, false)
        return ArtistViewHolder(artistsView)
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "getItemCount called")
        return artists.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder called for position ${position}")
        holder.bindTo(artists[position])
//        val artist = artists[position]
//        holder.txtArtistName.text = artist.name
//        holder.txtArtistUrl.text = artist.url
    }
}

class ArtistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var artist: ArtistDto
    public val txtArtistName: TextView = view.findViewById<TextView>(R.id.txtArtistName)
    public val txtArtistUrl: TextView = view.findViewById<TextView>(R.id.txtArtistUrl)

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
