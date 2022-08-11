package two

class HTMLElement(
    val name: String,
    val config: Config.()->Unit = {}
) {
    private val _config = Config().apply { config()}
    private val attributes: Map<String, String> = _config.attributes

    private var content = ""

    fun add(hElement: HTMLElement) {
        content += hElement.toString()
    }
    fun add(string: String) {
        content += string
    }

    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }

    override fun toString() =
        "<$name $attrs>\n$content\n</$name>"

    class Config{
        val attributes: MutableMap<String, String> = HashMap()
    }

    companion object {
        fun div(config: Config.()->Unit = {}) =
            HTMLElement("div", config)

        fun p(config: Config.()->Unit = {}) =
            HTMLElement("p", config)
    }
}