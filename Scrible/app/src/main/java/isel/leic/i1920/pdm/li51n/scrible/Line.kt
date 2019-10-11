package org.isel.pdm

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable

class Line() : Parcelable {
    private val points : MutableList<XyPair> = mutableListOf()

    constructor(x: Float, y: Float) : this() {
        add(x, y)
    }


    fun draw(canvas: Canvas?) {
        val paint = Paint()
        paint.setColor(Color.RED)
        paint.strokeWidth = 20f

        points.reduce { prev, curr ->
            canvas?.drawLine(prev.x, prev.y, curr.x, curr.y, paint)
            curr
        }
    }

    fun add(x: Float, y: Float) {
        points.add(XyPair(x, y))
    }


    constructor(parcel: Parcel) : this() {
        var pointsArr: Array<XyPair> = parcel.createTypedArray(XyPair.CREATOR)!!
        pointsArr.forEach { this.points.add(it) }  // pointsA.forEach(points::add)
    }



    override fun writeToParcel(dest: Parcel?, flags: Int) {
        var pointsArray: Array<XyPair> = points.toTypedArray()

        dest?.writeTypedArray(pointsArray, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR: Parcelable.Creator<Line> {
        override fun createFromParcel(source: Parcel): Line {
            return Line(source)
        }

        override fun newArray(size: Int): Array<Line?> {
            return arrayOfNulls(size)
        }

    }

}
