package three

import AttrName
import AttrValue

open class HTMLTag(
    val name: String,
    val builder: Builder,
) {

    operator fun String.unaryPlus() {
        builder.onTagContent(this)
    }

    fun attribute(name: AttrName, value: AttrValue) {
        builder.onAttributeAdd(name, value)
    }

    fun ul(block: UL.() -> Unit) =
        UL(builder).visit(block)

    companion object {
        fun div(block: HTMLTag.() -> Unit): HTMLElement? {
            val builder = Builder()
            HTMLTag("div", builder)
                .visit(block)
            return builder.finalize()
        }
    }

}

fun <T : HTMLTag> T.visit(block: T.() -> Unit) {
    builder.onStart(this)
    block()
    builder.onEnd()
}

class UL(builder: Builder) : HTMLTag("ul", builder){
    fun li(block: HTMLTag.() -> Unit) =
        HTMLTag("li", builder).visit(block)
}