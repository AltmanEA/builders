package one

class HTMLElement(
    val name: String,
    attributes: Map<String, String> = emptyMap()
) {
    private var content = ""

    fun add(hElement: HTMLElement) {
        content += hElement.toString()
    }
    fun add(string: String) {
        content += string
    }

    val attrs = attributes.toList()
        .joinToString(" ") { "${it.first}=\"${it.second}\"" }

    override fun toString() =
        "<$name $attrs>\n$content\n</$name>"

    companion object {
        fun div(attributes: Map<String, String> = emptyMap()) =
            HTMLElement("div", attributes)

        fun p(attributes: Map<String, String> = emptyMap()) =
            HTMLElement("p", attributes)
    }
}