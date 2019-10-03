package isel.leic.i1920.pdm.li51n.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    init {
        lifecycle.addObserver(LifecycleLogger(DetailsActivity::class.java.simpleName))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        var receivedMesssage: String = intent.getStringExtra(MESSAGE)

        println("$$$ ${intent.action}")
        message.text = receivedMesssage

    }
}
