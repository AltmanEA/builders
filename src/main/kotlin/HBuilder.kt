import HElement.Companion.div
import HElement.Companion.p
import java.io.File

fun main(){
    val div = div(
        "Hello",
        mapOf("id" to "root")
    ){
        p("in p 2").toString()
    }

    File("result.html").printWriter().use{
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