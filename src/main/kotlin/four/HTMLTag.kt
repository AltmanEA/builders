package four

class HTMLTag(
    val name: String,
    val builder: Builder,
) {
    fun visit(block: HTMLTag.() -> Unit) {
        builder.onStart(this)
        block()
        builder.onEnd()
    }

    operator fun String.unaryPlus() {
        builder.onTagContent(this)
    }

    fun attribute(name: AttributeName, value: AttributeValue) {
        builder.onAttributeAdd(name, value)
    }

    fun div(block: HTMLTag.() -> Unit) =
        HTMLTag("div", builder).visit(block)

    fun p(block: HTMLTag.() -> Unit) =
        HTMLTag("p", builder).visit(block)

    companion object {
        fun div(block: HTMLTag.() -> Unit): HTMLElement? {
            val builder = Builder()
            HTMLTag("div", builder)
                .visit(block)
            return builder.finalize()
        }
    }

}