class HElement(
    val name: String,
    var content: String,
    val attributes: Map<String, String> = emptyMap(),
    val builder: HElement.()->String = {""}
) {
    init {
        content += builder()
    }
    fun add(hElement: HElement) {
        content += hElement.toString()
    }

    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }

    override fun toString()=
        "<$name $attrs>$content</$name>"

    companion object {
        fun div(content: String, attributes: Map<String, String> = emptyMap(), builder: HElement.()->String = {""}) =
            HElement("div", content, attributes, builder)
        fun p(content: String, attributes: Map<String, String> = emptyMap(), builder: HElement.()->String = {""}) =
            HElement("p", content, attributes, builder)
    }
}