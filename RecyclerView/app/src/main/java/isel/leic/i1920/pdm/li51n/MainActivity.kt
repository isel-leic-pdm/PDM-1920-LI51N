package isel.leic.i1920.pdm.li51n

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import isel.leic.i1920.pdm.li51n.lastfm.LastfmWebApi
import isel.leic.i1920.pdm.li51n.lastfm.createLastFmWebApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val lastfm : LastfmWebApi by lazy { createLastFmWebApi() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Setup recyclerArtists with ArtistsAdapter
         */
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerArtists)
        val recyclerView = recyclerArtists

        recyclerView.adapter = ArtistsAdapter(lastfm.searchArtist("muse", 1))
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}
