package two

import VarAttrMap

class HTMLElement(
    val name: String,
    val config: Config.()->Unit = {}
) {
    private val _config = Config().apply { config() }

    val attrs = _config.attributes.toList()
        .joinToString(" ") {
            "${it.first}=\"${it.second}\""
        }

    override fun toString() =
        "<$name $attrs>\n${_config.content}\n</$name>"

    class Config{
        val attributes: VarAttrMap = HashMap()
        var content = ""
        fun add(hElement: HTMLElement) {
            content += hElement.toString()
        }
        operator fun String.unaryPlus(){
            content += this
        }
        fun div(config: Config.()->Unit = {}) =
            add(Companion.div(config))
        fun p(config: Config.()->Unit = {}) =
            add(Companion.p(config))
    }

    companion object {
        fun div(config: Config.()->Unit = {}) =
            HTMLElement("div", config)

        fun p(config: Config.()->Unit = {}) =
            HTMLElement("p", config)
    }
}