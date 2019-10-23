package isel.leic.i1920.pdm.li51n.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import isel.leic.i1920.pdm.li51n.utils.AppError
import org.geniuz.lastfm.LastfmWebApiImpl

class ArtistsViewModel(application: Application) : AndroidViewModel(application) {
    var artists : Array<ArtistDto> = emptyArray()
    fun searchArtist(name: String, page: Int, successHandler: (Array<ArtistDto>) -> Unit, errorHandler: (AppError) -> Unit) {
        lastfm.searchArtist(name, page, { successHandler(it.results.artistMatches.artist) }, errorHandler)
    }

    val lastfm : LastfmWebApiImpl by lazy {
        LastfmWebApiImpl(application)
    }
}