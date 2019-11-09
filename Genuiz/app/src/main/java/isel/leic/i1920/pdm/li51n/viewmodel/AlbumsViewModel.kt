package isel.leic.i1920.pdm.li51n.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import isel.leic.i1920.pdm.li51n.GeniuzApplication
import isel.leic.i1920.pdm.li51n.lastfm.dto.AlbumDto
import isel.leic.i1920.pdm.li51n.utils.AppError
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import isel.leic.i1920.pdm.li51n.lastfmWebApi
import org.geniuz.lastfm.LastfmWebApiImpl

class AlbumsViewModel(val app: Application) : AndroidViewModel(app) {
    var albums : Array<AlbumDto> = emptyArray()
    fun getAlbums(mbid: String, page: Int, successHandler: (Array<AlbumDto>) -> Unit, errorHandler: (AppError) -> Unit) {
        app.lastfmWebApi.getAlbums(mbid, page, { successHandler(it.topalbums.album) }, errorHandler)
    }

}