package isel.leic.i1920.pdm.li51n.scrible

import android.graphics.Canvas
import android.graphics.Paint
import androidx.lifecycle.ViewModel
import org.isel.pdm.Line

class ScribleViewModel : ViewModel() {
    private val lines : MutableList<Line> = mutableListOf()


    fun add(line: Line) {
        lines.add(line)
    }

    fun draw(canvas: Canvas, paint: Paint) {
        lines.forEach { it.draw(canvas, paint) }

    }

}
