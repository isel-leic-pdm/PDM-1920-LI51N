package isel.leic.i1920.pdm.li51n.lastfm

import isel.leic.i1920.pdm.li51n.lastfm.dto.GetAlbumsDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.SearchDto
import isel.leic.i1920.pdm.li51n.utils.AppError

interface LastFmWebApi {
    fun searchArtist(
        name: String,
        page: Int,
        onSuccess: (SearchDto) -> Unit,
        onError: (AppError) -> Unit
    )

    fun getAlbums(mbid: String,
                  page: Int,
                  onSuccess: (GetAlbumsDto) -> Unit,
                  onError: (AppError) -> Unit
    )

}
