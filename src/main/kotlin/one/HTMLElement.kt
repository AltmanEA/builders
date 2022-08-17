package one

import AttrMap

class HTMLElement(
    val name: String,
    attributes: AttrMap = emptyMap()
) {
    private var content = ""

    fun add(hElement: HTMLElement) {
        content += hElement.toString()
    }
    fun add(string: String) {
        content += string
    }

    private val attrs = attributes.toList()
        .joinToString(" ") {
            "${it.first}=\"${it.second}\""
        }

    override fun toString() =
        "<$name $attrs>\n$content\n</$name>"

    companion object {
        fun div(attributes: AttrMap = emptyMap()) =
            HTMLElement("div", attributes)

        fun p(attributes: AttrMap = emptyMap()) =
            HTMLElement("p", attributes)
    }
}