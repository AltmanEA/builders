package three

import printToHtml

fun main() {
    val element = HTMLTag.div {
        attribute("id", "root")
        ul {// this: UL
            li { +"li1" }
            li { +"li2" }
        }
    }
    printToHtml(element!!)
}