package isel.leic.i1920.pdm.li51n

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.LastfmWebApiMock
import isel.leic.i1920.pdm.li51n.viewmodel.AlbumsViewModel
import isel.leic.i1920.pdm.li51n.viewmodel.ArtistsViewModel

class AlbumsActivity : AppCompatActivity() {

    val adapter : AlbumsAdapter by lazy {
        AlbumsAdapter(model)
    }
    val model : AlbumsViewModel by lazy {
        ViewModelProviders.of(this)[AlbumsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        /**
         * Setup recyclerArtists with ArtistsAdapter
         */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAlbums)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        /**
         * Setup artist name on top of the screen
         */
        val name= intent.getStringExtra(ARTIST_NAME)
        findViewById<TextView>(R.id.txtAlbumsArtistName).text = name

        val mbid = intent.getStringExtra(ARTIST_MBID)
        model.getAlbums(
            mbid,
            1,
            {
                model.albums = it
                adapter.notifyDataSetChanged()
            }
            , {err -> throw err}
        )

    }
}
