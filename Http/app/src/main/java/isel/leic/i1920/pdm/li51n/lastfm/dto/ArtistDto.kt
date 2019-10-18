package isel.leic.i1920.pdm.li51n.lastfm.dto

class ArtistDto(
    val name: String,
    val listeners: Int,
    val mbid: String,
    val url: String,
    vararg val image: ImageDto
) {
    override fun toString(): String {
        return "ArtistDto(" +
                "\"$name\", " +
                "$listeners, " +
                "\"$mbid\" , " +
                "\"$url\", " +
                "${image.contentToString()})"
    }
}
