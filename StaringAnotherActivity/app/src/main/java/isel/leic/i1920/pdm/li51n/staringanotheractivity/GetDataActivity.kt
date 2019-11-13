package isel.leic.i1920.pdm.li51n.staringanotheractivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_data.*

class GetDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)


        ok.setOnClickListener {
            val intent = Intent()
            intent.putExtra(NAME, name.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
