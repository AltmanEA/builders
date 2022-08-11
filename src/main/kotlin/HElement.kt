interface Builder{
    var content: String
    fun HElement.visit(){
        this@Builder.content += result
    }
    operator fun String.unaryPlus(){
        content += this
    }
}

class HElement(
    val name: String,
    val attributes: Map<String, String> = emptyMap(),
    val build: Builder.() -> Unit = {}
) :Builder {
    override var content = ""
    init {
        build()
    }
    val attrs = attributes.toList().joinToString { "${it.first}=${it.second}" }
    val result =  "<$name $attrs>$content</$name>"

    companion object {
        fun Builder.div(
            attributes: Map<String, String> = emptyMap(),
            build: Builder.() -> Unit = { }
        ) =
            HElement("div", attributes, build ).visit()

        fun Builder.p(
            attributes: Map<String, String> = emptyMap(),
            build: Builder.() -> Unit = { }
        ) =
            HElement("p", attributes, build ).visit()
    }


}