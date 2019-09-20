package isel.leic.i1920.pdm.li51n

typealias IntSupplier = ()->Int

fun main() {
    print("Insert an expression in prefix notation: ")
    val input = "* + 3 4 + 7 2" //readLine() // + 2 3
    val ast = parse(input ?: "0")

    print("${prettyPrint(ast)} = ${eval(ast)}")
}


fun parse(input: String) : AstNode {

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






