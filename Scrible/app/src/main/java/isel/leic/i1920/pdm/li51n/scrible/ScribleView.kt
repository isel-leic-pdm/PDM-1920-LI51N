package isel.leic.i1920.pdm.li51n.scrible

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import org.isel.pdm.Line

class ScribleView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var currLine : Line? = null

    private val lines : MutableList<Line> = mutableListOf()

//    init {
//        isSaveEnabled = true;
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        lines.forEach { it.draw(canvas) }
    }



    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                currLine = Line(event.x, event.y)
                lines.add(currLine!!)
            }
            MotionEvent.ACTION_MOVE -> {
                currLine?.add(event.x, event.y)
            }
        }

        invalidate()
        return true
    }



    override fun onSaveInstanceState(): Parcelable {
        var superState = super.onSaveInstanceState()
        var bundle = Bundle()

        bundle.putParcelable("BASE", superState)

        var linesA: Array<Line> = lines.toTypedArray()
        bundle.putParcelableArray("LINES", linesA)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val bundle: Bundle = state as Bundle

        var superState:Parcelable = bundle.getParcelable("BASE")!!
        super.onRestoreInstanceState(superState)

        var linesA: Array<Line> = bundle.getParcelableArray("LINES")!! as Array<Line>
        lines.addAll(linesA)
    }
}