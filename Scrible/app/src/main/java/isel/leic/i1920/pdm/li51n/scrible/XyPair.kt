package org.isel.pdm

import android.os.Parcel
import android.os.Parcelable

class XyPair (val x: Float, val y: Float) : Parcelable{
    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeFloat(x)
        dest?.writeFloat(y)
    }

    companion object CREATOR: Parcelable.Creator<XyPair>  {
        override fun createFromParcel(source: Parcel?): XyPair {
            if(source != null)
                return XyPair(source?.readFloat(), source?.readFloat())
            throw Exception("Cannot read from null parcel")
        }

        override fun newArray(size: Int): Array<XyPair?> {
            return arrayOfNulls<XyPair>(size)
        }
    }

}



