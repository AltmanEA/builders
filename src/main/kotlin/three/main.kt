package three

import three.HTMLElement.Companion.div
import three.HTMLElement.Companion.p
import java.io.File

fun main() {
    val div1 = HTMLElement("div") {
        attributes["id"] = "root"
        attributes["class"] = "two"
        div {
            p {
                +"p1"
            }
        }
        p {
            +"p2"
        }
    }

    File("result.html").printWriter().use {
        it.print(
            """<html>
<header>
</header>
<body>
$div1
</body>
</html>"""
        )
    }
}