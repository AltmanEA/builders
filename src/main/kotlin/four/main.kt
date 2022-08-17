package four

import printToHtml

fun main() {
    val element = HTMLTag.div {
        attribute("id", "root")
        div {
            p {
                +"p1"
            }
        }
        p {
            +"p2"
        }
    }
    printToHtml(element!!)
}