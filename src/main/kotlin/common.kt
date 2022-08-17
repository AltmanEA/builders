import java.io.File

typealias AttrName = String
typealias AttrValue = String
typealias AttrMap = Map<AttrName, AttrValue>
typealias VarAttrMap = MutableMap<AttrName, AttrValue>

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

