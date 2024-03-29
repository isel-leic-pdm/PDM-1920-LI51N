package isel.leic.i1920.pdm.li51n.lastfm.dto

import com.google.gson.annotations.SerializedName

class SearchDto(val results: ResultsDto)

class ResultsDto(
    @field:SerializedName("opensearch:totalResults")
    val totalResults: Int, @field:SerializedName("artistmatches")
    val artistMatches: ArtistMatchesDto
)

class ArtistMatchesDto(val artist: Array<ArtistDto>)
