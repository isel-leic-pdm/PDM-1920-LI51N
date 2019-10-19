package isel.leic.i1920.pdm.li51n

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.LastfmWebApi
import isel.leic.i1920.pdm.li51n.lastfm.LastfmWebApiMock
import isel.leic.i1920.pdm.li51n.lastfm.createLastFmWebApi
import kotlinx.android.synthetic.main.activity_albums.*

class AlbumsActivity : AppCompatActivity() {

    val lastfm: LastfmWebApi by lazy { createLastFmWebApi() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        /**
         * Setup recyclerArtists with ArtistsAdapter
         */
        val mbid = intent.getStringExtra(ARTIST_MBID)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAlbums)
        recyclerView.adapter = AlbumsAdapter(lastfm.getAlbums(mbid, 1))
        recyclerView.layoutManager = LinearLayoutManager(this)
        /**
         * Setup artist name on top of the screen
         */
        val name= intent.getStringExtra(ARTIST_NAME)
        txtAlbumsArtistName.text = name
    }
}
