import java.io.File

fun printToHtml(obj: Any) {
    File("result.html").printWriter().use {
        it.print(
            """<html>
<header>
</header>
<body>
$obj
</body>
</html>"""
        )
    }
}
