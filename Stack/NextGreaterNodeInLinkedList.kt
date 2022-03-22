/*
You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.



Example 1:


Input: head = [2,1,5]
Output: [5,5,0]
Example 2:


Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]


Constraints:

The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109

Problem Link : https://leetcode.com/problems/next-greater-node-in-linked-list/
*/

/**
 * Solution : Used LinkedList to implement the Stack.
 * Stack push method will push the new value
 * to the front of the LinkedList.
 * Stack pop method will remove the head from the LinkedList.
 * Stack node will also contain an extra field which will store the index of the Pushed Element(Input Linked List)
 * If the Stack is empty or current node is less than or equal to Stack Top, we will push the node & index to Stack
 * else We will pop from the Stack & update the result array with the current Node
 * Next pop the elements from the Stack till the Stack is empty & update the result array index value as '0'
 */



/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun nextLargerNodes(head: ListNode?): IntArray {
        var size: Int = 0
        var temp = head
        while(temp != null) {
            size++
            temp = temp?.next
        }
        val arr = IntArray(size)
        var stack = Stack()
        temp = head
        var index = 0
        while (temp != null) {
            var value = temp?.`val`
            if ((stack.isEmpty()) || (value <= (stack.top() ?: Int.MIN_VALUE))) {
                stack.push(value, index)
                index++
                temp = temp?.next
            } else {
                var pair = stack.pop()
                arr[pair.second] = value
            }
        }
        while (!stack.isEmpty()) {
            val pair = stack.pop()
            arr[pair.second] = 0
        }

        return arr
    }
}

class Stack() {
    var linkedList: LinkedList = LinkedList()

    fun push(`val`: Int, index: Int) {
        linkedList.add(`val`, index)
    }

    fun pop(): Pair<Int, Int> {
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

    fun add(value: Int, index: Int) {
        var prevHead = head
        var node = Node()
        node.value = value
        node.index = index
        head = node
        head?.next = prevHead
        size++
    }

    fun remove(): Pair<Int, Int> {
        if (isEmpty()) return Pair(-1, -1)
        var prevHead = head
        head = head?.next
        size--
        return Pair(prevHead?.value ?: -1, prevHead?.index ?: -1) ?: Pair(-1, -1)
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
    var index: Int? = null
}

