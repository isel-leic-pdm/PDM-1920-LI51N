package isel.leic.i1920.pdm.li51n.expressionevaluator

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import isel.leic.i1920.pdm.li51n.ExpressionEvaluator
import kotlinx.android.synthetic.main.activity_main.*


private val LOG_ID = "MainActivity"

class MainActivity : AppCompatActivity() {
    val EXPRESSION_VALUE = "RESULT"



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result.text = savedInstanceState?.getString(EXPRESSION_VALUE) ?: result.text

        evaluate.setOnClickListener {
            var expressionEvaluator = ExpressionEvaluator(expression.text.toString())
            result.text = "${expressionEvaluator.prettyPrint} = ${expressionEvaluator.value}"
        }

        Log.i(LOG_ID, "##### onCreate called on ${this.hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_ID, "##### onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_ID, "##### onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_ID, "##### onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_ID, "##### onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LOG_ID, "##### onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_ID, "##### onDestroy called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXPRESSION_VALUE, result.text.toString())

        Log.i(LOG_ID, "##### onSaveInstanceState called")

    }
}
