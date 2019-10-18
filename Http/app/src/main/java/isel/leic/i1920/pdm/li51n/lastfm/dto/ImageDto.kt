package isel.leic.i1920.pdm.li51n.lastfm.dto

import com.google.gson.annotations.SerializedName

class ImageDto(
    @field:SerializedName("#text")
    val uri: String,
    val size: String
) {
    override fun toString(): String {
        return "ImageDto(\"$uri\", \"$size\")"
    }
}
