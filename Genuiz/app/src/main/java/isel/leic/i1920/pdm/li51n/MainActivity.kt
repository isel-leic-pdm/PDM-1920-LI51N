package isel.leic.i1920.pdm.li51n

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import kotlinx.android.synthetic.main.activity_main.*
import isel.leic.i1920.pdm.li51n.viewmodel.ArtistsViewModel
import org.geniuz.lastfm.LastfmWebApiImpl

const val TAG : String = "GENIUZ_APP"

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val adapter : ArtistsAdapter by lazy {
        ArtistsAdapter(model)
    }
    val model : ArtistsViewModel by lazy {
        ViewModelProviders.of(this, object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ArtistsViewModel(application.lastfmWebApi) as T
            }
        })[ArtistsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Setup recyclerArtists with ArtistsAdapter
         */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerArtists)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        /**
         * Setup search button
         */
        findViewById<Button>(R.id.buttonSearch).setOnClickListener(this)
    }
    override fun onClick(v: View) {
        /**
         * Fetch data
         */
        Log.v(TAG, "**** FETCHING from Last.fm...")
        val name = txtSearchArtistName.text.toString()
        model.searchArtist(name, 1)

        model.artists.observe(this, object: Observer<Array<ArtistDto>> {
            override fun onChanged(artists: Array<ArtistDto>) {
                adapter.notifyDataSetChanged()
                txtTotalArtists.text = artists.size.toString()
            }

        })
    }
}
