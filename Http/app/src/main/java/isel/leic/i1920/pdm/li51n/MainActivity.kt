package isel.leic.i1920.pdm.li51n

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import isel.leic.i1920.pdm.li51n.viewmodel.ArtistsViewModel

const val TAG : String = "GENIUZ_APP"

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val adapter : ArtistsAdapter by lazy {
        ArtistsAdapter(model)
    }
    val model : ArtistsViewModel by lazy {
        ViewModelProviders.of(this)[ArtistsViewModel::class.java]
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
        model.searchArtist(name, 1, {
            /**
             * Update UI
             */
            model.artists = it
            adapter.notifyDataSetChanged()
            txtTotalArtists.text = it.size.toString()
        }, {err -> throw err})

    }
}
