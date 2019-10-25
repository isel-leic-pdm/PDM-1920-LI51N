package isel.leic.i1920.pdm.li51n.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import isel.leic.i1920.pdm.li51n.utils.AppError
import org.geniuz.lastfm.LastfmWebApiImpl


class ArtistsViewModel(application: Application) : AndroidViewModel(application) {
    var artists : LiveData<Array<ArtistDto>> = MutableLiveData(emptyArray())

    var error : LiveData<AppError> = MutableLiveData()


    fun searchArtist(name: String, page: Int) : Unit {
        lastfm.searchArtist(name,
            page,
            { (artists as MutableLiveData).value = it.results.artistMatches.artist },
            { (error as MutableLiveData).value  = it }
            )
    }

    val lastfm : LastFmWebApi by lazy {
        LastfmWebApiImpl(application)
    }
}