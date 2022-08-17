package one

import one.HTMLElement.Companion.div
import printToHtml

fun main(){
    val element = div(
        mapOf("id" to "root")
    )
    val p1 = HTMLElement.p()
    p1.add("p1")
    val p2= HTMLElement.p()
    p2.add("p2")
    val p3: HTMLElement = HTMLElement.p()
    p3.add(p1)
    element.add(p3)
    element.add(p2)

    printToHtml(element)
}