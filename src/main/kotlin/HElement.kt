class HElement(
    val name: String,
    var content: String,
    val attributes: Map<String, String> = emptyMap()
) {
    fun add(hElement: HElement) {
        content += hElement.toString()
    }

    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }

    override fun toString()=
        "<$name $attrs>$content</$name>"

    companion object {
        fun div(content: String, attributes: Map<String, String> = emptyMap()) =
            HElement("div", content, attributes)
        fun p(content: String, attributes: Map<String, String> = emptyMap()) =
            HElement("p", content, attributes)
    }
}