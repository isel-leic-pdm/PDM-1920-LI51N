package isel.leic.i1920.pdm.li51n



open class AstNode

class Value(val value: Int) : AstNode()

class Operation(val oper: Char, val left: AstNode, val right: AstNode) : AstNode()


