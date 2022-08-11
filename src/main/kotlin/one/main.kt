import one.HTMLElement.Companion.div
import one.HTMLElement.Companion.p
import java.io.File

fun main(){
    val div1 = div(
        mapOf("id" to "root")
    )
    val p1 = p()
    p1.add("p content")
    div1.add(p1)

    File("result.html").printWriter().use{
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