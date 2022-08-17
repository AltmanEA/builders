package four

typealias AttributeName = String
typealias AttributeValue = String


open class HTMLElement(
    name: String
) : Node(name) {
    val childs = arrayListOf<Node>()
    val attributes: MutableMap<AttributeName, AttributeValue> = HashMap()

    private val attrs
        get() = attributes.toList()
            .joinToString(" ") {
                "${it.first}=\"${it.second}\""
            }
    private val inner
        get() = childs
            .joinToString("\n") { "$it" }

    override fun toString() =
        "<$name $attrs>\n$inner\n</$name>"
}

open class Node(
    val name: String
) {
    override fun toString() = name
}

