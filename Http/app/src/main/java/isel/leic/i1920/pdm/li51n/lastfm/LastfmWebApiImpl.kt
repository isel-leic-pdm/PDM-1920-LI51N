package org.geniuz.lastfm

import android.content.Context
import android.util.Log
import isel.leic.i1920.pdm.li51n.lastfm.LastFmWebApi
import isel.leic.i1920.pdm.li51n.lastfm.dto.GetAlbumsDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.SearchDto
import isel.leic.i1920.pdm.li51n.utils.AppError
import isel.leic.i1920.pdm.li51n.utils.HttpRequests

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

class LastfmWebApiImpl(ctx: Context) : LastFmWebApi {
    val TAG = LastfmWebApiImpl::class.java.name
    val httpRequestes = HttpRequests(ctx)



    override fun searchArtist(
        name: String,
        page: Int,
        onSuccess: (SearchDto) -> Unit,
        onError: (AppError) -> Unit)
    {
        val url = String.format(LASTFM_SEARCH, name, page)

        Log.i(TAG, "Making Request to Uri ${url}")


        httpRequestes.get(url, onSuccess, onError)

    }

    override fun getAlbums(mbid: String,
                           page: Int,
                           onSuccess: (GetAlbumsDto) -> Unit,
                           onError: (AppError) -> Unit) {

        val url = String.format(LASTFM_GET_ALBUMS, mbid, page)
        httpRequestes.get(url, onSuccess, onError)
    }
}