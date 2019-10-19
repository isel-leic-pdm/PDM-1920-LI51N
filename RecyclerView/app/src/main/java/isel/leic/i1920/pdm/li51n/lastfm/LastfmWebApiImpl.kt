package isel.leic.i1920.pdm.li51n.lastfm

import android.content.Context
import isel.leic.i1920.pdm.li51n.lastfm.dto.AlbumDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.GetAlbumsDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.SearchDto

const val LASTFM_API_KEY = "038cde478fb0eff567330587e8e981a4"
const val LASTFM_HOST = "http://ws.audioscrobbler.com/2.0/"
const val LASTFM_SEARCH = (LASTFM_HOST
        + "?method=artist.search&format=json&artist=%s&page=%d&api_key="
        + LASTFM_API_KEY)
const val LASTFM_GET_ALBUMS = (LASTFM_HOST
        + "?method=artist.gettopalbums&format=json&mbid=%s&page=%d&api_key="
        + LASTFM_API_KEY)
const val LASTFM_GET_ALBUM_INFO = (LASTFM_HOST
        + "?method=album.getinfo&format=json&mbid=%s&api_key="
        + LASTFM_API_KEY)

class LastfmWebApiImpl(ctx: Context) : LastfmWebApi {
    override fun searchArtist(name: String, page: Int): Array<ArtistDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAlbums(mbid: String, page: Int): Array<AlbumDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}