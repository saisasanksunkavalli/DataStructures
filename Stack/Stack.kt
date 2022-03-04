
class Stack {
    var linkedList: LinkedList = LinkedList()

    fun push(num: Int) {
        linkedList.add(num)
    }

    fun pop(): Int {
        return linkedList.remove()
    }

    fun top(): Int {
        return linkedList.top()
    }

    fun isEmpty(): Boolean {
        return linkedList.isEmpty()
    }
}

class LinkedList {
    var head: Node? = null
    var size: Int = 0

    fun add(value: Int) {
        var prevHead = head
        var node = Node()
        node.value = value
        head = node
        head?.next = prevHead
        size++
    }

    fun remove(): Int {
        if (isEmpty()) return -1
        var prevHead = head
        head = head?.next
        size--
        return prevHead?.value ?: -1
    }

    fun top(): Int {
        return head?.value ?: -1
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}


class Node {
    var next: Node? = null
    var value: Int? = null
}
