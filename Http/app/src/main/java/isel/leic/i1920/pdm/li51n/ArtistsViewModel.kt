package isel.leic.i1920.pdm.li51n

import androidx.lifecycle.ViewModel
import isel.leic.i1920.pdm.li51n.lastfm.dto.ArtistDto

class ArtistsViewModel(var artists : Array<ArtistDto> = emptyArray()) : ViewModel()