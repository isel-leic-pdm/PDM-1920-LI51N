package org.isel.geniuz

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.*
import org.isel.geniuz.model.Artist

class ArtistsViewModel() : ViewModel(), Parcelable {

    private val artistsLiveData : MediatorLiveData<Array<Artist>> = MediatorLiveData()

    val artists : Array<Artist>
        get() = artistsLiveData.value?: emptyArray()

    private var current : String? = null
    private var source: LiveData<List<Artist>>? = null

    constructor(parcel: Parcel) : this() {
        searchArtist(parcel.readString()!!)
    }
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(current)
    }
    override fun describeContents(): Int = 0

    fun searchArtist(name: String)
    {
        current = name
        if(source != null)
            artistsLiveData.removeSource(source!!)
        println("**** FETCHING Artists $name from Last.fm...")
        source = GeniuzApp.artistRepo.findByName(name)
        artistsLiveData.addSource(source!!) {
            println("**** FETCHING Artists $name COMPLETED !!!!")
            artistsLiveData.value = it.toTypedArray()
        }
    }

    fun observe(owner: LifecycleOwner, observer: (Array<Artist>) -> Unit) {
        artistsLiveData.observe(owner, Observer {
            observer(it)
        })
    }

    companion object CREATOR : Parcelable.Creator<ArtistsViewModel> {
        override fun createFromParcel(parcel: Parcel): ArtistsViewModel {
            return ArtistsViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ArtistsViewModel?> {
            return arrayOfNulls(size)
        }
    }
}