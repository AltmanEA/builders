package three

import printToHtml
import three.HTMLElement.Companion.div
import three.HTMLElement.Companion.p

fun main() {
    val element = HTMLElement("div") {
        attributes["id"] = "root"
        div {
            p {
                +"p1"
            }
        }
        p {
            +"p2"
        }
    }

    printToHtml(element)
}