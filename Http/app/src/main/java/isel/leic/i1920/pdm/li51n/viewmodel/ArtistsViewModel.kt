package isel.leic.i1920.pdm.li51n.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto
import org.geniuz.lastfm.LastfmWebApi

class ArtistsViewModel(var artists : Array<ArtistDto> = emptyArray()) : ViewModel() {
    fun searchArtist(name: String, i: Int, any: Any, any1: Any) {

    }

    val lastfm : LastfmWebApi by lazy {
        LastfmWebApi()
    }
}