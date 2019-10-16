package isel.leic.i1920.pdm.li51n.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        //viewModel = MainActivityViewModel()


        Log.i("MainActivity", "$$$ " + Thread.currentThread().id.toString())

        Thread({
            Log.i("MainActivity", "#### " + Thread.currentThread().id.toString())
            counterText.text = "1233423432"
        }).start()

        viewModel.getNames {

        }

    }


    fun increment(v: View) {
        counterText.text = (++viewModel.counter).toString()
    }

    fun decrement(v: View) {
        counterText.text = (--viewModel.counter).toString()
    }


}
