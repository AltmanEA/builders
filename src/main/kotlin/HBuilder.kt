import HElement.Companion.div
import HElement.Companion.p
import java.io.File

fun main() {
    val div = HElement("div") {
        div(
            mapOf("id" to "root")
        ) {
            p {
                +"p1"
            }
            p {
                +"p2"
            }
        }
    }.result

    File("result.html").printWriter().use {
        it.print(
            """
                <html>
                <header>
                </header>
                <body>
                $div
                </body>
                </html>
            """.trimIndent()
        )
    }
}