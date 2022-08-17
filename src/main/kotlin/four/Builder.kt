package four

class Builder {

    var path = arrayListOf<HTMLElement>()
    var lastLeaved: HTMLElement? = null

    fun onStart(tag: HTMLTag) {
        val element = HTMLElement(tag.name)
        if (path.isNotEmpty())
            path.last().childs.add(element)
        path.add(element)
    }

    fun onTagContent(string: String) {
        path.last().childs.add(
            Node(string)
        )
    }

    fun onAttributeAdd(name: AttributeName, value: AttributeValue) {
        path.last().attributes[name] = value
    }

    fun onEnd() {
        lastLeaved = path.removeAt(path.lastIndex)
    }

    fun finalize() = lastLeaved
}