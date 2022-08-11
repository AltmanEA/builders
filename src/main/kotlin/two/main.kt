package two

import two.HTMLElement.Companion.div
import two.HTMLElement.Companion.p
import java.io.File

fun main(){
    val div1 = div{
        attributes["id"] = "root"
        attributes["class"] = "two"
    }
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