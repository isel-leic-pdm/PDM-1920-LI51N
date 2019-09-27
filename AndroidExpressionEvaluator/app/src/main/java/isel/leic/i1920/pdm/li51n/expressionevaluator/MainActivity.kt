package isel.leic.i1920.pdm.li51n.expressionevaluator

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import isel.leic.i1920.pdm.li51n.ExpressionEvaluator
import kotlinx.android.synthetic.main.activity_main.*

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
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXPRESSION_VALUE, result.text.toString())

        Log.i("MainActivity", "##### onsaveInstanceState called")

    }
}
