package isel.leic.i1920.pdm.li51n

import kotlinx.android.synthetic.main.activity_main.*

typealias IntSupplier = ()->Int


private fun parse(input: String) : AstNode {

    fun getAst(tokens: MutableList<String>) : AstNode {
        if(tokens.size == 0)
            throw Exception("Invalid expression")
        val token = tokens.removeAt(0)
        var value: Int? = token.toIntOrNull()

        return if(value != null) Value(value) else Operation(token.get(0), getAst(tokens), getAst(tokens))
    }


    var tokens: MutableList<String> = input.split(" ").toMutableList()

    return getAst(tokens)
}

class ExpressionEvaluator(expression: String) {
    private val node = parse(expression)
    val value = eval(node).toString()
    val prettyPrint = prettyPrint(node)

}

fun evalAsString(input: String) : String  {
    val node = parse(input)
    return "${prettyPrint(node)} = ${eval(node).toString()}"
}








