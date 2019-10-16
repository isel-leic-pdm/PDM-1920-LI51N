package isel.leic.i1920.pdm.li51n.scrible

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.isel.pdm.Line

class ScribleView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var currLine : Line? = null

    val viewModel: ScribleViewModel by lazy {
        val activity = context as AppCompatActivity
        ViewModelProviders.of(activity)[ScribleViewModel::class.java]
    }

    companion object PAINT : Paint() {

        init {
            this.setColor(Color.RED)
            this.strokeWidth = 20f
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        viewModel.draw(canvas, PAINT)

    }



    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                currLine = Line(event.x, event.y)
                viewModel.add(currLine!!)
            }
            MotionEvent.ACTION_MOVE -> {
                currLine?.add(event.x, event.y)
            }
        }

        invalidate()
        return true
    }
}