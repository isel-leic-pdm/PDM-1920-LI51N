package isel.leic.i1920.pdm.li51n

import java.lang.Exception

fun eval(node: AstNode): Int {
    fun operation(char: Char): (x: Int, y: Int) -> Int {
        when(char) {
            '+' -> return { a, b -> a+b}
            '-' -> return { a, b -> a-b}
            '*' -> return { a, b -> a*b}
            else -> throw Exception("Invalid Operation")
        }
    }

    when(node) {
        is Value -> return node.value
        is Operation -> return operation(node.oper) (eval(node.left),eval(node.right))
        else -> throw Exception("Invalid Node")
    }


}

fun prettyPrint(node: AstNode): String {
    when(node) {
        is Value -> return node.value.toString()

        is Operation -> return "(${prettyPrint(node.left)} ${node.oper} ${prettyPrint(node.right)})"
        else -> throw Exception("Invalid Node")
    }
}
