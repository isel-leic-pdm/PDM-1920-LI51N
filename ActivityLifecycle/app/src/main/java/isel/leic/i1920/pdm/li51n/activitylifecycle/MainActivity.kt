package isel.leic.i1920.pdm.li51n.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val MESSAGE = "MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("### ${intent.action}")

        this.lifecycle.addObserver(LifecycleLogger("${MainActivity::class.java.simpleName}-1"))


        showDetails.setOnClickListener {
            val nameValue: String = name.text.toString().trim()
            if(nameValue != "") {
                var intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra(MESSAGE, nameValue)
                startActivity(intent)
            }
        }
    }
}



