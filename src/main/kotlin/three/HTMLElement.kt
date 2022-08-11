package three

interface Builder{
    var content: String
    val attributes: MutableMap<String, String>
    fun HTMLElement.visit(){
        this@Builder.content += this.toString()
    }
    operator fun String.unaryPlus(){
        content += this
    }
}

class HTMLElement(
    val name: String,
    build: Builder.()->Unit = {}
): Builder {
    override var content = ""
    override val attributes: MutableMap<String, String> = HashMap()

    init {
        build()
    }

    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }

    override fun toString() =
        "<$name $attrs>\n$content\n</$name>"

    class Config{
        val attributes: MutableMap<String, String> = HashMap()
    }

    companion object {
        fun Builder.div(build: Builder.()->Unit = {}) =
            HTMLElement("div", build).visit()

        fun Builder.p(build: Builder.()->Unit = {}) =
            HTMLElement("p", build).visit()
    }
}