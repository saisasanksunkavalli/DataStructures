/**
 * Implemented Stack DataStructure Using a LinkedList
 */
class Stack {
    var linkedList: LinkedList = LinkedList()

    /**
     * Pushes the element to the Stack
     */
    fun push(num: Int) {
        linkedList.add(num)
    }

    /**
     * Pops the element from the Stack & returns the Popped Element
     */
    fun pop(): Int {
        return linkedList.remove()
    }

    /**
     * Returns the top element of the Stack. Will return -1 if the Stack is Empty
     */
    fun top(): Int {
        return linkedList.top()
    }

    /**
     * Method to determine if the Stack is empty or not
     */
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
