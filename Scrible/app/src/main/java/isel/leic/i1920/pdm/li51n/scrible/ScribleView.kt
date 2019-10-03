package isel.leic.i1920.pdm.li51n.scrible

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import org.isel.pdm.Line

class ScribleView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var currLine : Line? = null

    private val lines : MutableList<Line> = mutableListOf()

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
}