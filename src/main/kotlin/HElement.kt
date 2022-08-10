class HElement(
    val name: String,
    val attributes: Map<String, String>,
    val content: String
) {
    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }

    override fun toString()=
        "<$name $attrs>$content</$name>"
}