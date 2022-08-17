package two

import printToHtml
import two.HTMLElement.Companion.div
import two.HTMLElement.Companion.p

fun main() {
    val element = div {
        attributes["id"] = "root"
        div {
            p { +"p1" }
        }
        p { +"p2" }
    }
    printToHtml(element)
}