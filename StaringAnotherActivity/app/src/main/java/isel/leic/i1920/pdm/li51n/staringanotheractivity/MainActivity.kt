package isel.leic.i1920.pdm.li51n.staringanotheractivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


const val DATA_REQUEST = 1  // The request code
const val NAME = "name"  // The request code

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        start.setOnClickListener {
            val intent = Intent(this, GetDataActivity::class.java)
            startActivityForResult(intent, DATA_REQUEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == DATA_REQUEST) {
            if(resultCode == Activity.RESULT_OK) {
                result.text = data?.getStringExtra(NAME)
            }
        }
    }
}
