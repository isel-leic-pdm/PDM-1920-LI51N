package isel.leic.i1920.pdm.li51n.lastfm

import isel.leic.i1920.pdm.li51n.lastfm.dto.AlbumDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto


interface LastfmWebApi {
    fun searchArtist(name: String, page: Int) : Array<ArtistDto>
    fun getAlbums(mbid: String, page: Int) : Array<AlbumDto>
}


fun createLastFmWebApi() : LastfmWebApi =
    LastfmWebApiMock()

    // If this implementation is used an android.os.NetworkOnMainThreadException is thrown because Android
    // detects blocking network activity on the User Interface Thread
    //LastfmWebApiBlocking()

