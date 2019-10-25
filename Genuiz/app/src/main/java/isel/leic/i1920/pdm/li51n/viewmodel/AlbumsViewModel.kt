package isel.leic.i1920.pdm.li51n.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import isel.leic.i1920.pdm.li51n.lastfm.dto.AlbumDto
import isel.leic.i1920.pdm.li51n.utils.AppError
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import org.geniuz.lastfm.LastfmWebApiImpl

class AlbumsViewModel(application: Application) : AndroidViewModel(application) {
    var albums : Array<AlbumDto> = emptyArray()
    fun getAlbums(mbid: String, page: Int, successHandler: (Array<AlbumDto>) -> Unit, errorHandler: (AppError) -> Unit) {
        lastfm.getAlbums(mbid, page, { successHandler(it.topalbums.album) }, errorHandler)
    }

    val lastfm : LastFmWebApi by lazy {
        LastfmWebApiImpl(application)
    }
}