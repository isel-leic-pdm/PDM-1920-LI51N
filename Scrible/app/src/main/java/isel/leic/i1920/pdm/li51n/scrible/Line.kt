package org.isel.pdm

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable

class Line() {
    private val points : MutableList<XyPair> = mutableListOf()

    constructor(x: Float, y: Float) : this() {
        add(x, y)
    }


    fun draw(canvas: Canvas, paint: Paint) {
        points.reduce { prev, curr ->
            canvas?.drawLine(prev.x, prev.y, curr.x, curr.y, paint)
            curr
        }
    }

    fun add(x: Float, y: Float) {
        points.add(XyPair(x, y))
    }
}
