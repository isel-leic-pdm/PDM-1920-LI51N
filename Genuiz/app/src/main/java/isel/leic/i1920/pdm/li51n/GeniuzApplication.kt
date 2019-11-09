package isel.leic.i1920.pdm.li51n

import android.app.Application
import android.util.Log
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import org.geniuz.lastfm.LastfmWebApiImpl

class GeniuzApplication: Application() {
    lateinit var lastfmWebApi: LastFmWebApi

    val TAG = GeniuzApplication::class.java.name
    override fun onCreate() {
        super.onCreate()

        lastfmWebApi = LastfmWebApiImpl(this)

        Log.i(TAG, "Application created")
    }
}


val Application.lastfmWebApi: LastFmWebApi
    get() = (this as GeniuzApplication).lastfmWebApi