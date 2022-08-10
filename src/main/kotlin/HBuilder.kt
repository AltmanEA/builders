import java.io.File

fun main(){
    val div = HElement(
        "div",
        mapOf("id" to "root"),
        "Hello"
    )

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